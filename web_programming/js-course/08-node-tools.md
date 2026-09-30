# Lesson 08: Node's Built-in Tools

← [Async](07-async.md) · Next: [A web server by hand](09-web-server-by-hand.md) →

> **Goal:** use the tools Node gives you for free: file paths, reading files, hashing passwords, and installing packages with npm. Needed for `basicNodeJS` and `practice_04`.

---

## 1. What Node is

**Node lets you run JavaScript outside the browser**, mostly to build servers. Everything in Lessons 01–07 works in Node. On top of that, Node adds **built-in modules** for things browsers can't do, like reading files on your computer.

```bash
node app.js
```

---

## 2. Free global values

These exist in every Node file (CommonJS style), with no `require` needed:

```js
console.log(__filename);   // full path of THIS file
console.log(__dirname);    // full path of the FOLDER this file is in
```

> ⚠️ **Two underscores** on each: `__dirname`, not `_dirname`. With one, you get `ReferenceError: _dirname is not defined`. That was the bug in your `basicNodeJS/app.js`.

`__dirname` is how you point at files next to your code, no matter which folder you ran `node` from:

```js
__dirname + '/users.json'    // "the users.json in the same folder as this file"
```

Also always available: `setTimeout`, `setInterval`, `clearTimeout`, `clearInterval` (Lesson 07), and `process.env` for settings like `process.env.PORT` (your `practice_0`).

---

## 3. `fs`: reading and writing files

```js
const fs = require('fs');    // built-in, so no ./
```

### Reading

```js
// Sync: wait here until it's read, then carry on
const text = fs.readFileSync(__dirname + '/notes.txt', 'utf8');
console.log(text);

// Async: hand it off, callback runs when done (Lesson 07)
fs.readFile(__dirname + '/notes.txt', 'utf8', function(err, text) {
    if (err) throw err;
    console.log(text);
});
```

| Word | Meaning |
|---|---|
| **`Sync`** | *synchronous*: the program **waits** on this line until the file is fully read |
| no `Sync` | *asynchronous*: hands the job off; the result arrives in the callback |
| **`'utf8'`** | the rulebook for turning the file's raw bytes into **letters**. Leave it out and you get raw bytes: `<Buffer 5b 0a ...>` |

### Reading a JSON file (`practice_04`)

```js
const users = JSON.parse(fs.readFileSync(__dirname + '/users.json', 'utf8'));
```

Read it **from the inside out**:

1. `__dirname + '/users.json'`: the file's location
2. `fs.readFileSync(..., 'utf8')`: read it → **text**
3. `JSON.parse(...)`: text → a **real array** you can use (Lesson 04)

### Where to put it

Your professor's tip: put this at the **top of the file**, not inside a route. Code at the top runs **once**, when the server starts. Inside a route, it would re-read the file on **every visit**. The trade-off: if you edit `users.json`, restart the server to see the change.

### Writing

```js
fs.writeFileSync(__dirname + '/out.txt', 'Hello Node');   // wait until written

fs.writeFile(__dirname + '/out.txt', 'Hello Node', function(err) {
    if (err) throw err;
    console.log("It's saved!");
});
```

---

## 4. `crypto`: hashing passwords

A **hash** turns any text into a **fixed-length fingerprint**:

```
'3333' → f56d6351aa71cff0debea014d13525e42036187a
'3333' → f56d6351aa71cff0debea014d13525e42036187a   ← same input, always the same
'3334' → 077fcabe880dbde6013401db76fe1ec48c57eaec   ← change one digit, totally different
```

And **you can't go backwards** from the fingerprint to the password. That's why it's safe to show or store the hash but not the real password.

### The code, step by step

```js
const crypto = require('crypto');

const hashed = crypto.createHash('sha1').update('3333').digest('hex');
// 'f56d6351aa71cff0debea014d13525e42036187a'
```

It's a **chain**: each `.something()` acts on what the previous step handed back. Split up, it's:

```js
const hasher = crypto.createHash('sha1');   // 1. get an empty hasher using the SHA-1 recipe
hasher.update('3333');                      // 2. feed the text in
const hashed = hasher.digest('hex');        // 3. finish, get the fingerprint as text
```

| Step | Does | Hands back |
|---|---|---|
| `createHash('sha1')` | makes an empty hasher, SHA-1 recipe | the hasher |
| `.update(text)` | feeds text in (can be called several times, for pieces) | **the same hasher**, which is why you can chain |
| `.digest('hex')` | finishes and produces the result | **text**: 40 characters of `0-9` and `a-f` |

- `'sha1'` is the recipe. `'sha256'` is another, stronger one.
- `'hex'` is how the result is written out. `'base64'` gives the **same** fingerprint written differently.

> 📝 Your professor's slide says the password must be "encrypted". What it actually wants is **hashed**. Encryption can be reversed with a key; hashing can't.

---

## 5. npm: installing other people's code

npm is the **app store** for JavaScript packages, like Express.

```bash
npm init -y              # once per project: creates package.json
npm install express      # downloads Express into node_modules/
```

| File / folder | What it is | Commit to git? |
|---|---|---|
| `package.json` | the list of packages your project needs | ✅ yes |
| `package-lock.json` | exact versions, so everyone gets the same | ✅ yes |
| `node_modules/` | the downloaded code itself (big!) | ❌ **no**, put it in `.gitignore` |

Anyone can rebuild `node_modules` by running `npm install`, because `package.json` records what's needed.

> 📝 Node looks for `node_modules` in the current folder, then **each folder above it**. That's why one `npm install express` in `web_programming_workspace` covers every `practice_XX` folder inside it.

---

## 6. Other built-in tools (know they exist)

The Node slides show many more. You don't need to memorize these. Just know they exist, so you can look them up when a lab needs one:

| Module | Used for | Slide |
|---|---|---|
| `assert` | quick tests: `assert(1 + 2 === 3, 'maths broke')` | Ex05 |
| `Buffer` | raw bytes. Use `Buffer.from('text')`, **not** the old `new Buffer()` | Ex06 |
| `dns` | turn a website name into an IP address | Ex09 |
| `os` | info about the computer: `os.hostname()`, `os.platform()` | Ex13 |
| `readline` | ask the user a question in the terminal | Ex14 |
| streams | handle big files piece by piece: `fs.createReadStream(...)` | Ex15 |
| `URL` | split an address into parts: `new URL('http://...')` | Ex16 |

---

## ✏️ Try it

1. Make `lesson08.js` that prints `__dirname` and `__filename`.
2. Make a `notes.txt` with a few lines, then read it with `readFileSync` and print it.
3. Remove the `'utf8'`. What prints now? Put it back.
4. Make a `users.json` (copy your `practice_04` one), read it, parse it, and print the **second** user's fullname.
5. Print the SHA-1 hash of `'1111'`. Check: it should start with `011c945f`.
6. Write the hash in 3 separate lines (hasher / update / digest), and check it gives the same answer.

<details>
<summary>Answers (open after trying)</summary>

```js
const fs = require('fs');
const crypto = require('crypto');

// 1
console.log(__dirname);
console.log(__filename);

// 2
const text = fs.readFileSync(__dirname + '/notes.txt', 'utf8');
console.log(text);

// 3: without 'utf8' you get raw bytes: <Buffer 68 65 6c ...>

// 4
const users = JSON.parse(fs.readFileSync(__dirname + '/users.json', 'utf8'));
console.log(users[1].fullname);   // Tom Cat

// 5
console.log(crypto.createHash('sha1').update('1111').digest('hex'));
// 011c945f30ce2cbafc452f39840f025693339c42

// 6
const hasher = crypto.createHash('sha1');
hasher.update('1111');
console.log(hasher.digest('hex'));   // same
```
</details>

---

### ✅ Checklist: you're ready for Lesson 09 when you can...

- [ ] explain what `__dirname` is and why it has two underscores
- [ ] explain `readFileSync` vs `readFile`, and what `'utf8'` does
- [ ] read and parse a JSON file in one line
- [ ] hash a password with SHA-1 and explain each step of the chain
- [ ] explain why `node_modules` goes in `.gitignore`
