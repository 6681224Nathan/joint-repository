# Lesson 09: A Web Server by Hand

← [Node's built-in tools](08-node-tools.md) · Next: [Express](10-express.md) →

> **Goal:** build a web server with Node's built-in `http` module. This is `EX01` and `practice_0`. Doing it by hand first makes Express (Lesson 10) easy to understand.

---

## 1. What a web server does

A web server is like **a waiter**:

1. It stands there, **waiting**.
2. A browser comes along and **asks** for something: *"can I have `/about`?"*
3. The server works out what to **hand back**, and hands it over.
4. It goes back to waiting for the next person.

In Node, you write **one function**, and it runs for **every single visit**.

---

## 2. The smallest server

```js
const http = require('http');

const server = http.createServer(function(req, res) {
    res.writeHead(200, { 'Content-Type': 'text/html' });
    res.end('<h1>Hello!</h1>');
});

server.listen(8081);
```

Run `node server.js`, then open **http://localhost:8081** in your browser.

The function you give `createServer` is a **callback** (Lesson 03). You write it; **the server calls it**, once for every visit, and fills in the two inputs:

| Input | Short for | Is |
|---|---|---|
| **`req`** | request | **what the browser asked for**. Most useful: `req.url`, the path, like `/` or `/about` |
| **`res`** | response | **what you send back** |

---

## 3. Every response has three parts

```js
res.writeHead(200, { 'Content-Type': 'text/html' });   // ① status  ② type
res.end('<h1>Hello!</h1>');                            // ③ send and finish
```

**① Status code:** did it work?

| Code | Meaning |
|---|---|
| `200` | OK |
| `400` | bad request (the visitor sent something invalid) |
| `404` | not found |
| `500` | the server broke |

**② Content-Type:** what kind of thing you're sending, so the browser knows how to show it:

| Content-Type | For |
|---|---|
| `text/html` | a web page |
| `text/plain` | plain text |
| `application/json` | data |

**③ `res.end(...)`:** send it and **finish**.

> ⚠️ **Forget `res.end()` and the browser keeps loading forever.** It's the most common server bug. Every visit must end with exactly one response.

---

## 4. `listen`: switching it on

```js
server.listen(8081, function() {
    console.log('Server running at http://localhost:8081');
});
```

Everything above `listen` only **describes** the server. `listen` **opens the door** and starts waiting.

- **`8081` is the port**, the door number on your computer. Different programs wait at different doors.
- **`localhost`** means "this computer".
- So `http://localhost:8081` = "this computer, door 8081".
- The callback runs once, when the server is ready. It's handy for printing the address.

Your `practice_0` uses `process.env.PORT || 8080`: the PORT setting if there is one, otherwise 8080 (Lesson 01, `||`).

---

## 5. Different pages for different URLs (routing)

Look at `req.url` and choose what to send, with a normal `if / else if / else` (Lesson 02):

```js
const server = http.createServer(function(req, res) {
    console.log('Someone asked for:', req.url);

    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>Home page</h1>');
    } else if (req.url === '/about') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>About me</h1>');
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 - Page not found</h1>');
    }
});
```

The final `else` catches **every URL you didn't plan for**. That's your 404 page.

That `console.log` at the top prints each visit in the terminal. It's a great way to see what the browser is really asking for.

---

## 6. Sending an HTML file

Writing HTML inside strings gets messy. Put it in a real `index.html` next to your code, and send the file:

```js
const fs = require('fs');

// Way A: read it, then send it
res.writeHead(200, { 'Content-Type': 'text/html' });
res.end(fs.readFileSync(__dirname + '/index.html', 'utf8'));

// Way B: stream it (the slides' way, Ex17-1)
res.writeHead(200, { 'Content-Type': 'text/html' });
fs.createReadStream(__dirname + '/index.html').pipe(res);
```

`.pipe(res)` pours the file into the response **and finishes it**, so no `res.end()` is needed with Way B.

---

## 7. Sending JSON data

For data, not a page (what a Vue front end will ask for later):

```js
res.writeHead(200, { 'Content-Type': 'application/json' });
res.end(JSON.stringify({ name: 'Pin', course: 'EGCI427' }));
```

`res.end` can only send **text**, so `JSON.stringify` (Lesson 04) turns the object into text first.

---

## 8. Running, stopping, restarting

| Situation | Do |
|---|---|
| start | `node server.js`. It won't give the prompt back. That's normal: it's waiting for visitors |
| stop | **`Ctrl + C`** in that terminal |
| changed the code | **stop and start again**. A running server doesn't notice your edits |
| `EADDRINUSE` / "port already in use" | another server is still running on that port. Find that terminal and `Ctrl + C` it |

---

## 9. The whole thing together

```js
const http = require('http');
const fs = require('fs');

const server = http.createServer(function(req, res) {
    console.log('Someone asked for:', req.url);

    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(fs.readFileSync(__dirname + '/index.html', 'utf8'));
    } else if (req.url === '/api/user') {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ name: 'Pin', course: 'EGCI427' }));
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 - Page not found</h1>');
    }
});

server.listen(8081, function() {
    console.log('Server running at http://localhost:8081');
});
```

| Visit | You get |
|---|---|
| `/` | the `index.html` page |
| `/api/user` | `{"name":"Pin","course":"EGCI427"}` |
| anything else | the 404 page |

---

## ✏️ Try it

Do this **without looking** at the examples above, as much as you can. Peek only when stuck.

1. Write the smallest server (step 2) from memory. Open it in your browser.
2. Add a `/hello` page that says `Hello, <your name>`.
3. Add a 404 for everything else. Test with `/nope`.
4. Add `/time` that sends JSON: `{ "time": "<current time>" }`. (Hint: `new Date().toString()`.)
5. Make an `index.html` and send it at `/`.
6. Remove the `res.end` from one route and visit it. What happens? Put it back.

<details>
<summary>Answers (open after trying)</summary>

```js
const http = require('http');
const fs = require('fs');

const server = http.createServer(function(req, res) {
    if (req.url === '/') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(fs.readFileSync(__dirname + '/index.html', 'utf8'));
    } else if (req.url === '/hello') {
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end('<h1>Hello, Pin</h1>');
    } else if (req.url === '/time') {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ time: new Date().toString() }));
    } else {
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>404 - Page not found</h1>');
    }
});

server.listen(8081);
```

**6.** The browser keeps loading forever, because the response was never finished.
</details>

---

### ✅ Checklist: you're ready for Lesson 10 when you can...

- [ ] write a working server from memory
- [ ] explain what `req` and `res` are, and who fills them in
- [ ] name the three parts of every response
- [ ] route different URLs with `if / else if / else`, including a 404
- [ ] send a page, and send JSON
