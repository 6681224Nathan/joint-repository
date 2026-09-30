# Lesson 10: Express

← [A web server by hand](09-web-server-by-hand.md) · Back to [Start here](00-start-here.md)

> **Goal:** build servers the easy way with Express, then put everything from this course together to build `practice_04` and `practice_05`.

---

## 1. Express = Lesson 09, with less typing

Express does **exactly** what your hand-made server did. It just handles the boring parts for you.

```js
// By hand (Lesson 09)
http.createServer(function(req, res) {
    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>Hello World</h1>');
    }
}).listen(8081);

// Express
app.get('/', function(req, res) {
    res.send('<h1>Hello World</h1>');
});
app.listen(8081);
```

No `if (req.url === ...)`, no `writeHead`, no Content-Type.

---

## 2. Setting up

Express isn't built in, so install it (Lesson 08), **once**, in your project folder:

```bash
npm init -y
```

```bash
npm install express
```

(Your `web_programming_workspace` already has it, so every `practice_XX` folder inside can use it.)

---

## 3. Hello World

```js
const express = require('express');
const app = express();

app.get('/', function(req, res) {
    res.send('<h1>Hello World</h1>');
});

app.listen(8081, function() {
    console.log('Server running at http://localhost:8081');
});
```

| Line | Meaning |
|---|---|
| `require('express')` | open the Express toolbox |
| `express()` | **build an empty server**. Call it `app` (your professor sometimes uses `routing`, which is the same thing) |
| `app.get('/', callback)` | "when someone visits `/`, **call this function**" |
| `res.send(...)` | send the reply. Works out the Content-Type and finishes the response |
| `app.listen(8081)` | open the door at port 8081 |

The route's function is a **callback** again (Lesson 03). Express calls it for each visit and fills in `req` and `res`.

---

## 4. Ways to reply

| Method | Sends | Example |
|---|---|---|
| `res.send(text)` | HTML / text | `res.send('<h1>Hi</h1>')` |
| `res.json(object)` | JSON. Stringifies it **and** sets the Content-Type | `res.json({ result: 68 })` |
| `res.sendFile(path)` | a file | `res.sendFile(__dirname + '/index.html')` |
| `res.status(code)` | sets the status code, then chain a send | `res.status(404).send('not found')` |

> ⚠️ Still **one response per visit**. And after sending an error early, `return` so the rest of the function doesn't also try to send.

**You also get a free 404.** Any URL with no route gets `Cannot GET /whatever` automatically.

---

## 5. Fill-in-the-blank URLs: route params

```js
app.get('/profile/:name', function(req, res) {
    res.send('<h1>Welcome ' + req.params.name + '</h1>');
});
```

The **`:`** marks a blank. Whatever's in that spot of the URL ends up in `req.params`, under that name:

| Visit | `req.params.name` |
|---|---|
| `/profile/Pin` | `'Pin'` |
| `/profile/tom` | `'tom'` |

With `/c2f/:value`, it'd be `req.params.value`. With `/profile/:id`, it's `req.params.id`.

> ⚠️ **Params are always TEXT.** `/profile/1` gives `'1'`, not `1`. If you compare against numbers, convert with `Number(...)`. If your data has text ids like `"1"`, compare directly.

> ⚠️ Two routes with the same shape (`/profile/:name` and `/profile/:id`) clash. Express uses the **first** one written, and the second never runs.

---

## 6. ⭐ `practice_04`: putting it all together

**Task:** read `users.json`; at `/profile/<id>`, show that user with the password **hashed** with SHA-1.

```js
const express = require('express');                            // Lesson 10
const fs = require('fs');                                      // Lesson 08
const crypto = require('crypto');                              // Lesson 08

const app = express();

// read the file ONCE, at startup
const users = JSON.parse(fs.readFileSync(__dirname + '/users.json', 'utf8'));   // Lessons 04 + 08

app.get('/', function(req, res) {
    res.sendFile(__dirname + '/index.html');
});

app.get('/profile/:id', function(req, res) {                   // Lesson 10: params
    const user = users.find(function(u) {                      // Lessons 03 + 04: callback, .find
        return u.id === req.params.id;                         // both are text, so === works
    });

    if (!user) {                                               // Lesson 01: !undefined is true
        res.status(404).send('<h1>User ' + req.params.id + ' not found</h1>');
        return;                                                // Lesson 03: stop here
    }

    const hashed = crypto.createHash('sha1').update(user.password).digest('hex');   // Lesson 08

    res.send(
        'id: ' + user.id + '<br>' +
        'username: ' + user.username + '<br>' +
        'password: ' + hashed + '<br>' +
        'fullname: ' + user.fullname
    );
});

app.listen(8081);
```

Every line comes from an earlier lesson. In words:

> *"At startup, read `users.json` into a list. When someone visits `/profile/<id>`, find the user with that id. If there's nobody, send 404 and stop. Otherwise, hash their password and send their details."*

Visiting `/profile/2`:

```
id: 2
username: John
password: f56d6351aa71cff0debea014d13525e42036187a
fullname: John Doe
```

---

## 7. ⭐ `practice_05`: an API that returns JSON

**Task:** 4 routes (`/c2f/:value`, `/f2c/:value`, `/c2k/:value`, `/k2c/:value`), each answering with JSON like `{ "result_type": "Fahrenheit", "result": 68 }`.

All four routes do the same thing with a different conversion, so there's **one helper**, and each route hands it **which function to use** (a callback, Lesson 03):

```js
const express = require('express');
const temp = require('./tempConverter.js');     // Lesson 06

const app = express();

function sendResult(res, value, resultType, convert) {
    const number = Number(value);               // URL gives text → number
    if (isNaN(number)) {
        res.status(400).json({ error: value + ' is not a number' });
        return;
    }
    res.json({
        result_type: resultType,
        result: Number(convert(number).toFixed(2))   // call the function we were given
    });
}

app.get('/c2f/:value', function(req, res) {
    sendResult(res, req.params.value, 'Fahrenheit', temp.celsiusToFahrenheit);   // no () !
});

app.get('/f2c/:value', function(req, res) {
    sendResult(res, req.params.value, 'Celsius', temp.fahrenheitToCelsius);
});

// ...c2k and k2c the same way...

app.listen(3000);
```

`temp.celsiusToFahrenheit` has **no brackets**: you're handing over the recipe, and `sendResult` runs it with `convert(number)`. Same idea as `setTimeout(helloWorld, 3000)` and `.find(function(u) {...})`.

---

## 8. Middleware: the guard at the door (Ex20)

**Middleware** runs **before** your routes, like a security guard checking everyone who comes in. It's used for logging, checking logins, and so on.

```js
app.use(function(req, res, next) {
    console.log(new Date(), req.method, req.url);
    next();                    // ← "all good, let them through"
});

app.get('/', function(req, res) {
    res.send('<h1>Hello</h1>');
});
```

The guard gets **three** inputs: `req`, `res`, and **`next`**. Calling `next()` passes the visitor on to the next matching route.

> ⚠️ **Every guard must either call `next()` or send a response itself.** The slide's Ex20 forgets `next()`. The guard logs the visitor and never lets them through, so the browser loads forever.

`app.use('/user', ...)` guards only URLs starting with `/user`. `app.use(...)` with no path guards everything.

---

## 9. By hand vs Express

| Job | By hand (Lesson 09) | Express |
|---|---|---|
| build a server | `http.createServer(fn)` | `express()` |
| a page for a URL | `if (req.url === '/about')` | `app.get('/about', fn)` |
| send a reply | `res.writeHead(...)` + `res.end(...)` | `res.send(...)` |
| send JSON | `JSON.stringify` + Content-Type | `res.json(obj)` |
| send a file | `fs...pipe(res)` | `res.sendFile(path)` |
| value from the URL | cut it out of `req.url` yourself | `/:id` → `req.params.id` |
| 404 | your own final `else` | automatic |
| run code before routes | awkward | middleware + `next()` |

---

## ✏️ Final challenge

**Rebuild both labs in new, empty folders**, e.g. `challenge_04` and `challenge_05` inside `web_programming_workspace`, **without looking** at your old code or these lessons. Peek only when truly stuck, then close it and keep going.

**Challenge A: `practice_04` from scratch**
1. Copy only `users.json` into the new folder.
2. Write the Express server: `/` sends a greeting, `/profile/:id` shows the user with the hashed password.
3. Test `/profile/0`, `/profile/2` and `/profile/9`.

**Challenge B: `practice_05` from scratch**
1. Write `tempConverter.js` with the 4 functions, exported.
2. Write `app.js` that prints the 3 conversion lines, then serves the 4 JSON APIs on port 3000.
3. Test `/c2f/20` → 68 and `/f2c/30` → -1.11.

**Challenge C (bonus):** add middleware to Challenge A that logs every visit's URL to the terminal.

If you can do A and B mostly from memory, you're ready for every assignment so far. 🎉

<details>
<summary>Hint for Challenge C</summary>

```js
app.use(function(req, res, next) {
    console.log('visit:', req.url);
    next();
});
```

Put it **above** your routes: Express runs things in the order you write them.
</details>

---

### ✅ Final checklist

- [ ] set up a folder with Express and start a server
- [ ] write routes with `app.get`, using `res.send`, `res.json`, `res.sendFile`, `res.status`
- [ ] use `req.params` and remember it's always text
- [ ] explain every line of `practice_04` and `practice_05`
- [ ] write middleware that calls `next()`
