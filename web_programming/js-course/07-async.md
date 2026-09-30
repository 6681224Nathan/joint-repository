# Lesson 07: Async (Timers, Promises, `async` / `await`)

← [Modules](06-modules.md) · Next: [Node's built-in tools](08-node-tools.md) →

> **Goal:** handle things that finish **later**, like timers, reading files and network requests. Needed for `basicNodeJS`, `practice_03`, and every server.

---

## 1. Normal code runs top to bottom, one line at a time

```js
console.log('1');
console.log('2');
console.log('3');
// 1 2 3
```

Each line finishes before the next starts. JavaScript has **one worker**, and by default it does things strictly in order.

---

## 2. Slow things get handed off

Some jobs are **slow**: waiting 3 seconds, reading a file, fetching from a website. JavaScript doesn't stand around waiting for them. It **hands the job off**, carries on with the next line, and deals with the result **later**.

```js
console.log('A');
setTimeout(function() {
    console.log('B');
}, 2000);
console.log('C');
```

Output:

```
A
C
B        ← 2 seconds later
```

`setTimeout` doesn't pause anything. It **writes a reminder** ("in 2 seconds, run this") and returns immediately. `C` prints straight away. `B` arrives later, after the rest of the script is done.

> 🔑 **The rule:** all your normal top-to-bottom code runs **first**. Things scheduled for later happen **after**.

---

## 3. Timers

```js
// once, later
const t = setTimeout(helloWorld, 3000);   // run helloWorld in 3 seconds
clearTimeout(t);                          // cancel it

// repeatedly
let i = 0;
const counter = setInterval(function() {
    i++;
    console.log(i);                       // 1, 2, 3... every 2 seconds
}, 2000);

setTimeout(function() {
    clearInterval(counter);               // stop after 10 seconds
}, 10000);
```

- The first input is a **callback** (Lesson 03): hand over `helloWorld` **without** brackets.
- The number is in **milliseconds**: `1000` = 1 second.
- `setTimeout` / `setInterval` hand back a ticket (`t`, `counter`) that you use to cancel.

### Why `clearTimeout` "wins" (your `basicNodeJS` question)

```js
const t = setTimeout(helloWorld, 3000);
clearTimeout(t);
```

`clearTimeout` is a normal line, so it runs **right now**, a millisecond in. `helloWorld` isn't due for **3000** milliseconds. By then the reminder has already been torn up, so `helloWorld` **never runs** and nothing prints. That's the lesson, not a bug.

---

## 4. Callbacks for "when it's done"

Many Node functions take a callback to run **when the slow job finishes**:

```js
const fs = require('fs');

fs.readFile('notes.txt', 'utf8', function(err, text) {
    if (err) {
        console.log('failed:', err.message);
        return;
    }
    console.log(text);
});

console.log('this prints FIRST');
```

Note the shape: **error first, then the result**. If `err` has something in it, the job failed. Nearly every Node callback looks like this.

### The trap: using the result too early

```js
let content;
fs.readFile('notes.txt', 'utf8', function(err, text) {
    content = text;
});
console.log(content);   // undefined! The file hasn't been read yet.
```

The `console.log` runs **before** the file is read. **You can only use the result inside the callback** (or with `await`, below). This is the lesson of the Node slides' Ex04.

---

## 5. Promises: the buzzer

Nesting callbacks inside callbacks gets messy quickly. A **Promise** is a cleaner way to handle "this finishes later".

> 🔔 Think of a **restaurant buzzer**. You order, and instead of food you get a buzzer. It's not your food. It **stands in for** food that isn't ready yet. Later it buzzes (food's ready ✅) or the waiter says sorry (out of stock ❌).

A Promise is always in one of three states:

| State | Buzzer |
|---|---|
| **pending** | still waiting |
| **fulfilled** (resolved) | it buzzed, your result is ready ✅ |
| **rejected** | something went wrong ❌ |

### Making a buzzer

```js
function orderCoffee() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            resolve('☕ coffee');     // ← press the buzzer, handing over the result
        }, 2000);
    });
}
```

`new Promise(...)` gives you **two buttons**, `resolve` and `reject`. Nobody presses them for you. **You** decide when:

- `resolve(value)`: success, hand over `value`
- `reject(error)`: failure

### Listening to a buzzer: `.then` and `.catch`

```js
orderCoffee()
    .then(function(drink) {
        console.log('got', drink);        // runs when resolve() is pressed
    })
    .catch(function(err) {
        console.log('problem:', err);     // runs if reject() is pressed
    });
```

- `.then(callback)`: when it buzzes, run this with the result
- `.catch(callback)`: if it fails, run this

### Chaining several steps

This is `practice_03`:

```js
getUser(1)
    .then(user => {
        console.log('User:', user.name);
        return getPosts(user.id);          // ← return the NEXT buzzer
    })
    .then(posts => {
        posts.forEach(p => console.log('Post:', p.title));
    })
    .catch(err => console.error('Error:', err));
```

When a `.then` **returns** another Promise, the next `.then` waits for **that** one. So it's: get the user → then get their posts → then print them. One `.catch` at the end covers every step.

---

## 6. `async` / `await`: the same thing, easier to read

`await` lets you write Promise code that **reads** top to bottom:

```js
async function loadUserPosts() {
    try {
        const user = await getUser(1);          // wait for the buzzer, take the result
        console.log('User:', user.name);

        const posts = await getPosts(user.id);  // wait again
        posts.forEach(p => console.log('Post:', p.title));
    } catch (err) {
        console.error('Error:', err);
    }
}

loadUserPosts();
```

That's your `practice_03/app2.js`. It does **exactly** the same as the `.then` chain above.

### The rules

| Rule | Meaning |
|---|---|
| `await promise` | pause **this function** until it buzzes, then give back the result |
| `await` only works inside an **`async`** function | `async` is the permission slip |
| `try / catch` | replaces `.catch()`. If any `await` fails, it jumps to `catch` |
| an `async` function **always returns a Promise** | even if you `return 'hello'`, the caller gets a buzzer |

### Why must an `async` function return a Promise?

Because it's allowed to **pause** in the middle, at an `await`. When someone calls it, it might still be waiting, so it **can't** have its final answer ready yet. The only honest thing it can hand back is a **buzzer**: *"I'm not done. I'll let you know."*

### `await` pauses only its own function

```js
async function morning() {
    console.log('ordering');
    const drink = await orderCoffee();   // this function pauses here...
    console.log('got', drink);
}

morning();
console.log('meanwhile...');             // ...but the rest of the program carries on
```

```
ordering
meanwhile...
got ☕ coffee      ← 2 seconds later
```

### Several at once: `Promise.all`

`await` one after another waits for each in turn. If the jobs **don't depend on each other**, start them together (this code goes inside an `async` function):

```js
// one at a time: ~2 seconds
const coffee = await makeCoffee();
const toast  = await makeToast();

// together: ~1 second
const [coffee2, toast2] = await Promise.all([makeCoffee(), makeToast()]);
```

---

## 7. Which style should you use?

| Style | When you'll see it |
|---|---|
| callbacks `function(err, data)` | Node's built-in tools, the Node slides |
| `.then()` / `.catch()` | `practice_03`, older code |
| `async` / `await` | modern code, Vue. **Easiest to read, so prefer this** when you write your own |

They're all the same idea: **something finishes later, and here's what to do when it does.**

---

## ✏️ Try it

1. Predict the order, **then** run it:
   ```js
   console.log('1');
   setTimeout(() => console.log('2'), 0);
   console.log('3');
   ```
2. Write `wait(ms)` that returns a Promise which resolves after `ms` milliseconds.
3. Use `wait` with `.then` to print `done` after 1 second.
4. Write an `async` function that prints `a`, waits 1 second, prints `b`, waits 1 second, prints `c`.
5. **Fix `practice_03/app.js`.** It has two bugs:
   - It uses `getUser`, but that's in `promise.js` and isn't exported/required.
   - Look carefully at the name inside the second `.then`.

<details>
<summary>Answers (open after trying)</summary>

**1.** `1`, `3`, `2`. Even with 0 milliseconds, `setTimeout` schedules the callback for *after* the current top-to-bottom code finishes.

```js
// 2
function wait(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

// 3
wait(1000).then(() => console.log('done'));

// 4
async function abc() {
    console.log('a');
    await wait(1000);
    console.log('b');
    await wait(1000);
    console.log('c');
}
abc();
```

**5.** In `promise.js`, add at the bottom (and make sure `getPosts` has its closing `}`):

```js
module.exports = { getUser, getPosts };
```

In `app.js`, add at the top:

```js
const { getUser, getPosts } = require('./promise.js');
```

And in the second `.then`, the input is called `posts`, but the code uses `post`:

```js
.then(posts => {
    posts.forEach(p => console.log('Post:', p.title));   // posts, not post
})
```
</details>

---

### ✅ Checklist: you're ready for Lesson 08 when you can...

- [ ] explain why `setTimeout`'s callback runs *after* the lines below it
- [ ] explain why `clearTimeout(t)` stops `helloWorld` from ever running
- [ ] make a Promise with `resolve`, and use it with `.then`
- [ ] rewrite a `.then` chain with `async` / `await` and `try / catch`
- [ ] explain why an `async` function always returns a Promise
