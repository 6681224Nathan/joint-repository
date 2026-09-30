# JavaScript from the Ground Up: Start Here

This course takes you from zero to being able to do every Web Programming assignment so far, one small lesson at a time.

> **How to read these files nicely:** open one in VS Code and press **`Cmd + Shift + V`**. That shows the formatted version, with headings, tables and coloured code.

---

## How to use this course

1. **Do the lessons in order.** Each one uses only what came before it.
2. **Type the examples yourself.** Don't copy and paste. Typing is how the code gets into your fingers, not just your head. This is the part you said you're missing.
3. **Do the "Try it" section** at the end of each lesson before opening the answers.
4. **Stuck? Ask Claude.** Mention the lesson and the step, like *"lesson 03, step 4 doesn't make sense."*

One lesson a day is a good pace. You don't need to finish everything in one sitting.

---

## How to run code

Make a file ending in `.js`, for example `test.js`, then in the VS Code terminal (`` Ctrl + ` `` opens it):

```bash
node test.js
```

Anything inside `console.log(...)` gets printed in the terminal. When you're not sure what something holds, **`console.log` it.** That's the most useful habit in all of JavaScript.

A **server** keeps running and doesn't give the prompt back. Stop it with **`Ctrl + C`**.

---

## The lessons

| # | Lesson | You'll be able to... |
|:-:|---|---|
| 01 | [Values and variables](01-values-and-variables.md) | store text, numbers and true/false; compare them |
| 02 | [Decisions and loops](02-decisions-and-loops.md) | make the code choose, and repeat things |
| 03 | [Functions](03-functions.md) | package code, **and pass functions to other functions** |
| 04 | [Arrays and objects](04-arrays-and-objects.md) | hold lists and records; use `.find`, `.map`, JSON |
| 05 | [Classes](05-classes.md) | make blueprints for objects |
| 06 | [Modules](06-modules.md) | split code across files with `require` / `import` |
| 07 | [Async: timers, Promises, await](07-async.md) | handle things that finish *later* |
| 08 | [Node's built-in tools](08-node-tools.md) | read files, hash passwords, use npm |
| 09 | [A web server by hand](09-web-server-by-hand.md) | build a server with the `http` module |
| 10 | [Express](10-express.md) | build servers the easy way; APIs and routes |

**Lesson 03 is the most important one.** It covers the `function(u)` idea you got stuck on. Everything from lesson 04 onwards depends on it, so take your time there.

---

## Which lesson unlocks which assignment

| Assignment | What it is | Needs lessons |
|---|---|---|
| `EX01`, `practice_0` | a tiny `http` server | 01, 03, 09 |
| `practice_01` | `Product` / `DiscountedProduct` classes | 01, 03, 05 |
| `practice_02` | `math.js` with `import` / `export` | 03, 05, 06 |
| `practice_03` | Promises with `.then()` | 03, 04, 07 |
| `practice_03 / app2.js` | the same thing with `async` / `await` | 07 |
| `basicNodeJS` | `__dirname`, `setTimeout`, `clearTimeout` | 07, 08 |
| `practice_04` | Express user profile, `users.json`, SHA-1 | 04, 08, 10 |
| `practice_05` | temperature converter module + 4 APIs | 03, 06, 10 |

By the end of lesson 10, you should be able to rewrite `practice_04` and `practice_05` from an empty file, without looking.

---

## Other notes in this folder

- `../es6_examples/`: the runnable buzzer / async examples
- `../web_programming_workspace/practice_04/find-explained.md`: the deep dive on `.find`
