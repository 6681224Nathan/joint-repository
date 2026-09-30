# Lesson 06: Modules (Splitting Code Across Files)

← [Classes](05-classes.md) · Next: [Async](07-async.md) →

> **Goal:** put functions in one file and use them from another. Needed for `practice_02` and `practice_05`.

---

## 1. The idea

Each file is **its own private room**. Nothing inside it can be seen from other files, **unless you choose to share it**.

- **Export** = put something on a shelf by the door, for other files to take.
- **Import / require** = take it from another file's shelf.

There are **two ways** of writing this in JavaScript, and your course uses both:

| | Way 1: CommonJS | Way 2: ES Modules |
|---|---|---|
| Share | `module.exports = { ... }` | `export ...` |
| Take | `require('./file.js')` | `import ... from './file.js'` |
| Used in | **your Node & Express labs** (`practice_04`, `practice_05`) | the ES6 slides, `practice_02`, Vue later |

Same idea, different words. **You can't mix them in one file.**

---

## 2. Way 1: `module.exports` and `require`

### The file that shares: `math.js`

```js
function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

function secretHelper() {
    // not exported, so other files can't use it
}

module.exports = {
    add: add,
    multiply: multiply
};
```

`module.exports` is **the shelf**. Whatever object you put there is exactly what other files receive.

`{ add: add }` means "a key called `add`, holding the function `add`". Since the key and the value have the same name, ES6 lets you shorten it:

```js
module.exports = { add, multiply };   // same thing, shorter
```

### The file that uses it: `app.js`

```js
const math = require('./math.js');

console.log(math.add(1, 2));        // 3
console.log(math.multiply(3, 4));   // 12
```

`require('./math.js')` hands back **whatever was on the shelf**, which is the object `{ add, multiply }`. So `math.add` is the `add` function.

Or take just the pieces you need, with destructuring (Lesson 04):

```js
const { add, multiply } = require('./math.js');

console.log(add(1, 2));   // 3
```

### The `./` rule

| You write | Node looks for |
|---|---|
| `require('./math.js')` | **your own file**, in the same folder |
| `require('../math.js')` | your own file, one folder **up** |
| `require('fs')` | a **built-in** Node module (no `./`) |
| `require('express')` | an **npm package** from `node_modules` (no `./`) |

> ⚠️ Forget the `./` on your own file and Node thinks it's a package: `Error: Cannot find module 'math.js'`.

### The other style you'll see: `exports.name = ...`

The Node slides (Ex03) use this:

```js
exports.area = function(r) {
    return Math.PI * r * r;
};
```

It adds **one** item to the shelf at a time. Both styles work. `module.exports = { ... }` is clearer when you have several things.

---

## 3. Way 2: `export` and `import` (ES6)

### Named exports: share several things by name

```js
// math.js
export const PI = 3.14159;

export function add(a, b) {
    return a + b;
}

const subtract = (a, b) => a - b;
export { subtract };             // or export at the end
```

```js
// app.js
import { PI, add, subtract } from './math.js';

console.log(add(1, 2));   // 3
```

**Braces `{ }`, and the names must match exactly.**

### Default export: the one main thing in a file

```js
// math.js
export default class Calculator {
    add(a, b) { return a + b; }
}
```

```js
// app.js
import Calculator from './math.js';    // NO braces, and any name you like

const calc = new Calculator();
```

A file can have **only one** default export, plus any number of named ones.

### Other import tricks

```js
import { add as sum } from './math.js';   // rename while importing
import * as MathTools from './math.js';   // everything, as one object
MathTools.add(1, 2);
```

### Braces or no braces?

| Import | Meaning |
|---|---|
| `import X from ...` | the **default** export. Name it whatever you want |
| `import { x } from ...` | a **named** export. The name must match |

---

## 4. ⚠️ How Node knows which way a file uses

Node looks for the **nearest `package.json`** above the file, and checks its `"type"`:

| `package.json` says | Node expects |
|---|---|
| `"type": "commonjs"` (or no type) | `require` / `module.exports` |
| `"type": "module"` | `import` / `export` |

Using the wrong one gives:

```
SyntaxError: Cannot use import statement outside a module
```

### Why your `practice_02` stopped working

When Express was installed, a `package.json` was created in the main `web_programming_workspace` folder saying `"type": "commonjs"`. That applies to **every folder inside it**, including `practice_02`, which uses `import`.

**The fix:** put a small `package.json` **inside `practice_02`** containing:

```json
{ "type": "module" }
```

Node uses the **nearest** one, so `practice_02` switches to `import` style while every other folder stays on `require`. (Another option is renaming the files to end in `.mjs`.)

---

## 5. How `practice_05` fits together

```
practice_05/
├── tempConverter.js    ← defines 4 functions, puts them on the shelf
└── app.js              ← takes them off the shelf, uses them
```

```js
// tempConverter.js
function celsiusToFahrenheit(c) {
    return c * 9 / 5 + 32;
}
// ...three more...

module.exports = {
    celsiusToFahrenheit: celsiusToFahrenheit,
    // ...
};
```

```js
// app.js
var temp = require('./tempConverter.js');
temp.celsiusToFahrenheit(100);   // 212
```

`temp` is the object from the shelf, so `temp.celsiusToFahrenheit` is the function.

---

## ✏️ Try it

**Rebuild the first half of `practice_05` from an empty folder, without looking.** Make a new folder `lesson06`, and inside it:

1. `tempConverter.js` with the four functions:
   - `celsiusToFahrenheit(c)` → `c * 9/5 + 32`
   - `fahrenheitToCelsius(f)` → `(f - 32) * 5/9`
   - `celsiusToKelvin(c)` → `c + 273.15`
   - `kelvinToCelsius(k)` → `k - 273.15`
2. Export all four with `module.exports`.
3. `app.js` that requires it and prints:
   ```
   100°C = 212.00°F
   100°C = 373.15K
   212°F = 100.00°C
   ```
4. **Bonus:** change `app.js` to use destructuring: `const { celsiusToFahrenheit, ... } = require(...)`.

<details>
<summary>Answers (open after trying)</summary>

```js
// tempConverter.js
function celsiusToFahrenheit(c) {
    return c * 9 / 5 + 32;
}
function fahrenheitToCelsius(f) {
    return (f - 32) * 5 / 9;
}
function celsiusToKelvin(c) {
    return c + 273.15;
}
function kelvinToCelsius(k) {
    return k - 273.15;
}

module.exports = { celsiusToFahrenheit, fahrenheitToCelsius, celsiusToKelvin, kelvinToCelsius };
```

```js
// app.js
const temp = require('./tempConverter.js');

console.log(`100°C = ${temp.celsiusToFahrenheit(100).toFixed(2)}°F`);
console.log(`100°C = ${temp.celsiusToKelvin(100).toFixed(2)}K`);
console.log(`212°F = ${temp.fahrenheitToCelsius(212).toFixed(2)}°C`);
```

```js
// bonus: app.js with destructuring
const { celsiusToFahrenheit, celsiusToKelvin, fahrenheitToCelsius } = require('./tempConverter.js');

console.log(`100°C = ${celsiusToFahrenheit(100).toFixed(2)}°F`);
```
</details>

---

### ✅ Checklist: you're ready for Lesson 07 when you can...

- [ ] share functions with `module.exports` and use them with `require`
- [ ] explain when you need `./` and when you don't
- [ ] explain `import X` vs `import { x }`
- [ ] explain why `import` fails when `package.json` says `"commonjs"`
