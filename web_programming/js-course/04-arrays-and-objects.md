# Lesson 04: Arrays and Objects

← [Functions](03-functions.md) · Next: [Classes](05-classes.md) →

> **Goal:** hold lists and records, search them with `.find`, reshape them with `.map` / `.filter`, and convert them to and from JSON.

---

## 1. Arrays: ordered lists

```js
const fruits = ['apple', 'banana', 'cherry'];

fruits[0];        // 'apple'    ← positions start at 0
fruits[2];        // 'cherry'
fruits[5];        // undefined  ← nothing there
fruits.length;    // 3
```

Changing an array:

```js
fruits.push('mango');          // add to the end → ['apple', 'banana', 'cherry', 'mango']
fruits.includes('banana');     // true
fruits[0] = 'kiwi';            // replace position 0
```

> 📝 A `const` array can still be changed **inside**. `const` only stops you from replacing the whole box (`fruits = [...]`).

---

## 2. Objects: labelled records

An array is a list by **position**. An object is a record by **name**:

```js
const user = {
    username: 'bob',
    password: '1111',
    fullname: 'Bob Cat',
    id: '0'
};
```

Each line is a **key: value** pair. Getting values out:

```js
user.username       // 'bob'     ← dot style (use this normally)
user['fullname']    // 'Bob Cat' ← bracket style (same thing)
user.email          // undefined ← no such key
```

Adding and changing:

```js
user.email = 'bob@cat.com';   // adds a new key
user.fullname = 'Bobby Cat';  // changes an existing one
```

### The dots mean "go inside"

Objects can contain other objects. Each dot goes one level deeper:

```js
req.params.id
// req      → the request object
// .params  → an object inside it
// .id      → a value inside that
```

---

## 3. Arrays of objects: the shape of real data

Most real data is a **list of records**. This is your `practice_04` data:

```js
const users = [
    { username: 'bob',  password: '1111', fullname: 'Bob Cat',  id: '0' },
    { username: 'tom',  password: '2222', fullname: 'Tom Cat',  id: '1' },
    { username: 'John', password: '3333', fullname: 'John Doe', id: '2' }
];

users.length;            // 3
users[0];                // bob's whole object
users[0].fullname;       // 'Bob Cat'
users[2].username;       // 'John'
```

Read `users[2].username` left to right: *the users list → item at position 2 → its username.*

---

## 4. JSON: data as text

**JSON** is a way of writing arrays and objects **as text**, so they can be saved in a file or sent over the internet. It looks almost identical to JavaScript, with stricter rules:

| JSON rule | ✅ | ❌ |
|---|---|---|
| keys need **double** quotes | `"id": "1"` | `id: '1'` |
| text needs **double** quotes | `"bob"` | `'bob'` |
| no comma after the last item | `[1, 2]` | `[1, 2,]` |
| no comments | | `// note` |

Two tools convert between them:

```js
// text → real data you can use
const users = JSON.parse('[{"username":"bob","id":"0"}]');
users[0].username;   // 'bob'

// real data → text you can send or save
JSON.stringify({ name: 'Pin', course: 'EGCI427' });
// '{"name":"Pin","course":"EGCI427"}'
```

> **Parse** = read text and work out its structure.
> **Stringify** = turn a structure into a string (text).

Before `JSON.parse`, the data is just one long piece of text, so `text[0]` would be the character `[`. After parsing, it's a real array.

---

## 5. Destructuring: unpacking into variables (ES6)

Take values out of an object and give each its own variable, in one line:

```js
const user = { username: 'bob', fullname: 'Bob Cat' };

// long way
const username = user.username;
const fullname = user.fullname;

// destructuring: same result
const { username, fullname } = user;
```

The names in `{ }` must **match the keys**. It works for arrays too, by position:

```js
const [first, second] = ['apple', 'banana'];
// first = 'apple', second = 'banana'
```

You'll see it most with `require`:

```js
const { add, multiply } = require('./math.js');   // Lesson 06
```

---

## 6. Spread `...`: unpack into a new array or object (ES6)

```js
const a = [1, 2];
const b = [...a, 3, 4];           // [1, 2, 3, 4]

const user = { name: 'bob', age: 20 };
const older = { ...user, age: 21 };   // { name: 'bob', age: 21 }  ← copy, then change age
```

`...` means *"pour everything out of this, right here."* Handy for copying without changing the original.

### Rest `...`: the opposite, gather into one array

In a function's inputs, `...` **gathers** everything into an array:

```js
function total(...nums) {
    // nums is an array of everything passed in
    let sum = 0;
    for (const n of nums) sum += n;
    return sum;
}

total(1, 2, 3);   // 6
```

Same symbol, opposite job: **spread pours out, rest gathers in.**

---

## 7. ⭐ The four array tools

Each of these **goes through the array for you** and **calls your function once per item** (the callback idea from Lesson 03). What changes is **what they do with your function's answer**.

### `.forEach`: just do something with each one

```js
users.forEach(function(u) {
    console.log(u.username);
});
// bob
// tom
// John
```

Returns nothing. It's `for...of` in a different outfit.

### `.map`: turn each item into something new

```js
const names = users.map(function(u) {
    return u.username;
});
// ['bob', 'tom', 'John']
```

Your function's **return value** goes into a **new array**. Three items in, three items out.

### `.filter`: keep only the ones that pass

```js
const cats = users.filter(function(u) {
    return u.fullname.includes('Cat');
});
// [bob's object, tom's object]
```

Your function answers **"keep this one?"** with `true` / `false`. You get a new array of **every** item that got `true`.

### `.find`: get the first one that matches

```js
const john = users.find(function(u) {
    return u.id === '2';
});
// John's object
```

Your function answers **"is this the one?"** `.find` gives back **the first** item that gets `true`, then **stops**. If nobody gets `true`, it gives back `undefined`.

### Side by side

| Tool | Your function answers... | You get back |
|---|---|---|
| `.forEach` | nothing, just does something | nothing |
| `.map` | "what should this become?" | new array of **your answers** |
| `.filter` | "keep this?" `true` / `false` | new array of **every** `true` item |
| `.find` | "is this the one?" `true` / `false` | the **first** `true` item, or `undefined` |

### ⭐ How `.find` uses your `true` / `false`

Inside, `.find` is basically this (Lesson 02 loop + Lesson 03 callback):

```js
function find(list, question) {
    for (const item of list) {
        if (question(item)) {    // ← calls YOUR function, uses your true/false
            return item;         // ← first yes: hand back the item, stop
        }
    }
    return undefined;            // no yes at all
}
```

So **the `if` and the `return item` live inside `.find`**. Your function only supplies the yes/no that goes in the `if (...)`. That's why your callback is just:

```js
return u.id === req.params.id;   // "is this the one?" → true or false
```

Visiting `/profile/2`, `.find` does this:

| Turn | `u` is | `u.id === '2'` | `.find` does |
|:-:|---|:-:|---|
| 1 | bob | `false` | next |
| 2 | tom | `false` | next |
| 3 | John | **`true`** | **stop, give back John** |

### With arrow functions

The same four, shortened (Lesson 03, step 4):

```js
users.forEach(u => console.log(u.username));
const names = users.map(u => u.username);
const cats  = users.filter(u => u.fullname.includes('Cat'));
const john  = users.find(u => u.id === '2');
```

> 💡 **Reading trick:** ignore everything except what comes after `return` (or after `=>`). That's the question. The looping is always the same.

---

## 8. Two more collections: `Map` and `Set` (ES6)

You'll rarely need these for the labs, but they're in the ES6 slides.

```js
// Set: a list that refuses duplicates
const unique = [...new Set([1, 2, 2, 3, 3])];   // [1, 2, 3]

// Map: like an object, but keys can be anything (numbers, objects...)
const m = new Map();
m.set(42, 'the answer');
m.get(42);    // 'the answer'
m.size;       // 1
```

---

## ✏️ Try it

Use this data:

```js
const users = [
    { username: 'bob',  password: '1111', fullname: 'Bob Cat',  id: '0' },
    { username: 'tom',  password: '2222', fullname: 'Tom Cat',  id: '1' },
    { username: 'John', password: '3333', fullname: 'John Doe', id: '2' }
];
```

1. Print tom's fullname using positions and dots.
2. Use `.forEach` to print `username: fullname` for each user.
3. Use `.map` to make an array of just the ids.
4. Use `.find` to get the user whose username is `'John'`. Print his password.
5. Use `.find` for id `'9'`. What do you get? Write an `if` that prints `not found` in that case.
6. Use destructuring to pull `username` and `fullname` out of bob's object.
7. Turn `users` into JSON text with `JSON.stringify`, then back with `JSON.parse`. Print `typeof` both.

<details>
<summary>Answers (open after trying)</summary>

```js
// 1
console.log(users[1].fullname);   // Tom Cat

// 2
users.forEach(function(u) {
    console.log(u.username + ': ' + u.fullname);
});

// 3
const ids = users.map(u => u.id);   // ['0', '1', '2']

// 4
const john = users.find(u => u.username === 'John');
console.log(john.password);   // 3333

// 5
const nobody = users.find(u => u.id === '9');
console.log(nobody);          // undefined
if (!nobody) {
    console.log('not found');
}

// 6
const { username, fullname } = users[0];
console.log(username, fullname);   // bob Bob Cat

// 7
const text = JSON.stringify(users);
const back = JSON.parse(text);
console.log(typeof text);   // string
console.log(typeof back);   // object  (arrays count as objects to typeof)
```
</details>

---

### ✅ Checklist: you're ready for Lesson 05 when you can...

- [ ] get a value out of an array of objects, like `users[2].username`
- [ ] explain `JSON.parse` vs `JSON.stringify`
- [ ] say what `.map`, `.filter` and `.find` each give back
- [ ] explain where the `if` is when you use `.find`
- [ ] handle `.find` returning `undefined`
