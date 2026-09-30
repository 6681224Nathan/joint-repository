# Lesson 02: Decisions and Loops

← [Values and variables](01-values-and-variables.md) · Next: [Functions](03-functions.md) →

> **Goal:** make code choose between options, and repeat things.

---

## 1. `if`: do something only when...

```js
const score = 72;

if (score >= 50) {
    console.log('pass');
}
```

The part in `( )` is worked out to `true` or `false` (or something that *counts as* true or false, from Lesson 01). If it's true, the code in `{ }` runs. If not, it's skipped.

### `else` and `else if`

```js
if (score >= 80) {
    console.log('A');
} else if (score >= 70) {
    console.log('B');
} else if (score >= 50) {
    console.log('pass');
} else {
    console.log('fail');
}
```

JavaScript checks **top to bottom** and runs **only the first** block whose condition is true. Then it skips the rest.

With `score = 72`: `72 >= 80`? No. `72 >= 70`? **Yes**, so it prints `B` and stops checking.

> 📝 This is exactly how routing works in a hand-made server (Lesson 09): `if (req.url === '/') ... else if (req.url === '/about') ... else` → 404.

---

## 2. The short version: `? :`

When you just need to **pick one of two values**:

```js
const result = score >= 50 ? 'pass' : 'fail';
```

Read it as: *"is `score >= 50`? If yes, `'pass'`, otherwise `'fail'`."*

It's the same as:

```js
let result;
if (score >= 50) {
    result = 'pass';
} else {
    result = 'fail';
}
```

---

## 3. The `for` loop: repeat with a counter

```js
for (let i = 0; i < 3; i++) {
    console.log('round', i);
}
// round 0
// round 1
// round 2
```

The brackets have **three parts**, separated by `;`:

| Part | Meaning | When it runs |
|---|---|---|
| `let i = 0` | start the counter at 0 | once, at the beginning |
| `i < 3` | keep going **while** this is true | before every round |
| `i++` | add 1 to the counter (`i = i + 1`) | after every round |

### Looping through a list

The most common use: go through every item in an array (you'll learn arrays properly in Lesson 04).

```js
const names = ['bob', 'tom', 'John'];

for (let i = 0; i < names.length; i++) {
    console.log(i, names[i]);
}
// 0 bob
// 1 tom
// 2 John
```

- `names.length` is `3`, so `i` goes `0, 1, 2`.
- `names[i]` means "the item at position `i`". **Positions start at 0.**

---

## 4. `for...of`: the easy way through a list

If you don't need the position number, this is simpler:

```js
for (const name of names) {
    console.log(name);
}
// bob
// tom
// John
```

Read it as: *"for each `name` in `names`..."*. Each round, `name` holds the next item.

---

## 5. Stopping early: `break`

`break` means **"stop the loop right now."**

```js
for (const name of names) {
    console.log('checking', name);
    if (name === 'tom') {
        console.log('found tom!');
        break;
    }
}
// checking bob
// checking tom
// found tom!
```

John is never checked. This "search, then stop at the first match" is exactly what `.find` does for you (Lesson 04).

---

## 6. `while`: repeat until something changes

```js
let count = 3;
while (count > 0) {
    console.log(count);
    count--;            // count = count - 1
}
console.log('Go!');
// 3  2  1  Go!
```

You'll rarely need `while` in your labs. `for` and `for...of` cover almost everything.

> ⚠️ If the condition never becomes false, the loop runs **forever** and your program freezes. Press `Ctrl + C` to escape.

---

## ✏️ Try it

1. Make `const temp = 35`. Print `hot` if it's above 30, `nice` if it's 20–30, and `cold` otherwise.
2. Do the same thing with `? :`, but only for `hot` / `not hot`.
3. Print the numbers 1 to 5 with a `for` loop.
4. Make `const fruits = ['apple', 'banana', 'cherry']` and print each one with `for...of`.
5. Loop through `fruits` and stop as soon as you reach `'banana'`, printing `found it`.

<details>
<summary>Answers (open after trying)</summary>

```js
// 1
const temp = 35;
if (temp > 30) {
    console.log('hot');
} else if (temp >= 20) {
    console.log('nice');
} else {
    console.log('cold');
}

// 2
console.log(temp > 30 ? 'hot' : 'not hot');

// 3
for (let i = 1; i <= 5; i++) {
    console.log(i);
}

// 4
const fruits = ['apple', 'banana', 'cherry'];
for (const fruit of fruits) {
    console.log(fruit);
}

// 5
for (const fruit of fruits) {
    if (fruit === 'banana') {
        console.log('found it');
        break;
    }
}
```
</details>

---

### ✅ Checklist: you're ready for Lesson 03 when you can...

- [ ] write an `if / else if / else` chain
- [ ] explain the three parts of `for (let i = 0; i < n; i++)`
- [ ] loop through a list with `for...of`
- [ ] stop a loop early with `break`
