# Lesson 01: Values and Variables

← [Start here](00-start-here.md) · Next: [Decisions and loops](02-decisions-and-loops.md) →

> **Goal:** store information, look at it, and compare it.

---

## 1. Printing and comments

```js
console.log('Hello!');      // prints: Hello!
console.log(2 + 3);         // prints: 5
console.log('a', 'b', 1);   // prints several things: a b 1

// This is a comment. JavaScript ignores it. It's a note for humans.
```

`console.log` is how you **see** what your code is doing. Use it constantly.

---

## 2. Variables: labelled boxes

A variable is a **box with a label**. You put a value in it and use the label to get it back.

```js
const name = 'Pin';
let score = 0;

console.log(name);   // Pin
score = 10;          // put a new value in the box
console.log(score);  // 10
```

| Keyword | Can you put a new value in later? | When to use |
|---|---|---|
| `const` | ❌ no | **by default**, for most things |
| `let` | ✅ yes | when the value needs to change (counters, totals) |
| `var` | ✅ yes | the **old** way. Your professor's slides use it, and it still works, but new code uses `const` / `let` |

```js
const PI = 3.14;
PI = 3;              // ❌ error: you can't reassign a const
```

> 📝 In your labs you'll see `var` everywhere, because the slides use it. That's fine. Read `var` as "`let`, old style".

---

## 3. The basic kinds of value

| Kind | Examples | What it's for |
|---|---|---|
| **string** (text) | `'hello'`, `"hello"`, `` `hello` `` | words, names, messages |
| **number** | `42`, `3.14`, `-7` | maths. JavaScript has only one number type |
| **boolean** | `true`, `false` | yes / no |
| **undefined** | `undefined` | "nothing was ever put here" |
| **null** | `null` | "deliberately empty" |

`typeof` tells you what kind something is:

```js
console.log(typeof 'hi');       // string
console.log(typeof 42);         // number
console.log(typeof true);       // boolean
console.log(typeof undefined);  // undefined
```

---

## 4. Strings (text)

Three kinds of quotes. `'single'` and `"double"` do the same thing. **Backticks** (`` ` ``, the key under `Esc`) are special: they let you put values **inside** the text with `${ }`.

```js
const name = 'Pin';
const age = 21;

// Old way: glue pieces together with +
console.log('Hi ' + name + ', you are ' + age);

// ES6 way: template literal (backticks + ${})
console.log(`Hi ${name}, you are ${age}`);

// Anything can go inside ${}, even maths
console.log(`Next year you'll be ${age + 1}`);   // Next year you'll be 22
```

Both styles appear in your labs. `practice_04` uses `+`, and `practice_01` uses backticks.

Useful string tools:

```js
const word = 'hello';
word.length;          // 5
word.toUpperCase();   // 'HELLO'
word.includes('ell'); // true
```

---

## 5. Numbers

```js
10 + 3    // 13
10 - 3    // 7
10 * 3    // 30
10 / 3    // 3.3333333333333335
10 % 3    // 1   ← remainder ("10 divided by 3 is 3, remainder 1")
```

### Turning text into a number, and back

This comes up **all the time** with servers, because anything that arrives from a URL is text.

```js
Number('20')        // 20       (text → number)
Number('abc')       // NaN      ("Not a Number")
isNaN(Number('abc'))// true     (is it Not-a-Number? yes)

(212).toFixed(2)    // '212.00' (number → text, with 2 decimals)
```

> ⚠️ **`.toFixed()` gives back TEXT, not a number.** That's why `practice_05` does `Number(x.toFixed(2))`: round to 2 decimals, then turn it back into a number.

### Why `'20' + 1` is `'201'`

```js
'20' + 1    // '201'   ← text + anything = gluing text together
20 + 1      // 21      ← number + number = maths
```

If your maths gives strange answers, one of your values is probably text. `console.log(typeof x)` to check.

---

## 6. Comparing: always use `===`

A comparison **produces a boolean**, `true` or `false`, just like `2 + 3` produces `5`:

```js
5 === 5       // true    (equal)
5 !== 3       // true    (not equal)
5 > 3         // true
5 < 3         // false
5 >= 5        // true
5 <= 4        // false
```

**Use `===`, never `==`.** The double version quietly converts types, which causes weird bugs:

```js
'1' == 1      // true   ← converts text to number first. Sneaky.
'1' === 1     // false  ← different kinds, so not equal. Honest.
```

This is exactly why, in `practice_04`, the ids had to be the **same kind** on both sides. The URL gives text `'1'`, and `users.json` also has text `"1"`, so `===` matches them.

Since a comparison is just a value, you can store it:

```js
const isAdult = age >= 18;   // isAdult holds true
```

---

## 7. Combining: `&&`, `||`, `!`

```js
true && true     // true   AND: both must be true
true && false    // false

true || false    // true   OR: at least one must be true
false || false   // false

!true            // false  NOT: flips it
!false           // true
```

```js
const canEnter = age >= 18 && hasTicket;
```

---

## 8. Truthy and falsy: things that *count as* false

`if` doesn't need a real `true` / `false`. Anything can go in, and JavaScript decides if it **counts as** true or false.

These **six** count as false (they're "falsy"):

```js
false    0    ''    null    undefined    NaN
```

**Everything else** counts as true: any non-empty text, any number except 0, every object, every array (even empty ones).

This is how `practice_04`'s check works:

```js
const user = users.find(...);   // a user object, OR undefined if not found

if (!user) {        // !undefined → true, so this runs when nobody was found
    // send 404
}
```

### `||` as "use this, or else that"

`||` gives back the **first value that counts as true**. That makes it a handy way to set a fallback:

```js
const port = process.env.PORT || 8080;
```

Read it as: *"use the PORT setting if there is one, otherwise 8080."* This is from your `practice_0/app.js`.

---

## ✏️ Try it

Make `lesson01.js` and write code for each. Run it with `node lesson01.js`.

1. Make a `const` for your name and a `let` for your age. Print `My name is ___ and I am ___` using a **template literal**.
2. Add 1 to your age, then print it again.
3. What does `'5' + 5` print? What about `Number('5') + 5`? Predict first, then check.
4. Print whether `'7' === 7` is true or false. Why?
5. Make `const input = 'abc'`. Print whether it's Not-a-Number.

<details>
<summary>Answers (open after trying)</summary>

```js
// 1
const name = 'Pin';
let age = 21;
console.log(`My name is ${name} and I am ${age}`);

// 2
age = age + 1;          // or: age++
console.log(age);       // 22

// 3
console.log('5' + 5);           // '55'  (text glue)
console.log(Number('5') + 5);   // 10    (maths)

// 4
console.log('7' === 7);   // false: one is text, one is a number

// 5
const input = 'abc';
console.log(isNaN(Number(input)));   // true
```
</details>

---

### ✅ Checklist: you're ready for Lesson 02 when you can...

- [ ] explain the difference between `const` and `let`
- [ ] write a template literal with `${}`
- [ ] turn text into a number with `Number()`
- [ ] explain why `===` is safer than `==`
- [ ] say what `!user` means when `user` is `undefined`
