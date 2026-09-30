# Lesson 03: Functions

← [Decisions and loops](02-decisions-and-loops.md) · Next: [Arrays and objects](04-arrays-and-objects.md) →

> **Goal:** package code into reusable pieces, and **hand functions to other functions**. That second part is what `.find`, `setTimeout`, Express routes and Promises are all built on.

⭐ **This is the most important lesson in the course.** Go slowly. Type every example.

---

## 1. A function is a reusable recipe

```js
function greet(name) {
    return 'Hi ' + name;
}

console.log(greet('bob'));   // Hi bob
console.log(greet('tom'));   // Hi tom
```

| Part | Meaning |
|---|---|
| `function` | "I'm making a function" |
| `greet` | its name |
| `(name)` | its **input**, called a *parameter* |
| `{ ... }` | the recipe: the code that runs |
| `return` | the **output**: what it hands back |
| `greet('bob')` | **calling** it: actually running the recipe, with `'bob'` as the input |

Writing a function does **nothing** by itself. It only runs when something **calls** it, with `( )`.

---

## 2. ⭐ The golden rule: inputs are filled in by whoever calls

> **A function never decides its own inputs. Whoever calls the function fills them in.**

```js
function greet(name) {
    return 'Hi ' + name;
}

greet('bob');    // the caller says 'bob',  so name is 'bob'
greet('tom');    // the caller says 'tom',  so name is 'tom'
```

`name` is an empty slot. It gets a value **at the moment of the call**, from the call.

**Remember this rule.** It's the whole answer to "where does `u` come from?" later.

### Several inputs

Inputs are filled **in order**:

```js
function add(a, b) {
    return a + b;
}

add(2, 3);   // a is 2, b is 3 → 5
```

---

## 3. `return`: the output

`return` does two things:

1. **Hands a value back** to whoever called the function.
2. **Stops the function immediately.** Nothing after it runs.

```js
function check(age) {
    if (age < 18) {
        return 'too young';   // leaves here if under 18
    }
    return 'welcome';         // only reached if 18 or over
}

check(15);   // 'too young'
check(30);   // 'welcome'
```

That second job is why `practice_04` has `return;` right after sending the 404: **stop here, don't carry on**.

A function with no `return` hands back `undefined`.

### Returning a comparison

A comparison **is a value** (`true` / `false`, Lesson 01). So you can return it directly:

```js
function isAdult(age) {
    return age >= 18;      // hands back true or false
}

isAdult(20);   // true
isAdult(12);   // false
```

This isn't "return with a condition." It's "**work out** `age >= 18`, then return the answer." Keep this in mind for `.find`.

---

## 4. Arrow functions: the short way (ES6)

These all do the same thing (if you type them into one file, use only one at a time, since each uses the name `double`):

```js
// Classic
function double(x) {
    return x * 2;
}

// Arrow function
const double = (x) => {
    return x * 2;
};

// Arrow, shortest: one expression → it returns automatically
const double = x => x * 2;
```

Arrow function rules:

| You write | Meaning |
|---|---|
| `(a, b) => a + b` | two inputs, returns `a + b` |
| `x => x * 2` | one input: brackets optional |
| `() => console.log('hi')` | no inputs: empty brackets required |
| `x => { ... return ...; }` | several lines: needs `{ }` **and** `return` |

> ⚠️ With `{ }`, you **must** write `return`. Without `{ }`, you **must not**. Mixing these up is the #1 arrow function bug.

Your professor's slides mostly use the classic `function` style. Modern code (and Vue) mostly uses arrows. **Learn to read both**. Write whichever feels clearer.

---

## 5. Default inputs

```js
function greet(name = 'stranger') {
    return 'Hi ' + name;
}

greet('Pin');   // 'Hi Pin'
greet();        // 'Hi stranger'   ← nobody filled it in, so the default is used
```

---

## 6. ⭐ Functions are values

This is the big step. **A function is a value**, just like a number or text. That means you can:

**Keep it in a variable:**

```js
const sayHi = function(name) {
    return 'Hi ' + name;
};

sayHi('tom');   // 'Hi tom'
```

Notice `function(name) { ... }` has **no name** after the word `function`. That's allowed. It's a function without a name, kept in a variable called `sayHi`.

**Refer to it without calling it:**

```js
sayHi           // the function itself (the recipe)
sayHi('tom')    // CALLING it (running the recipe) → 'Hi tom'
```

> **No brackets = the recipe. Brackets = run the recipe.**

That difference matters in the next step.

---

## 7. ⭐ Handing a function to another function (callbacks)

Since a function is a value, you can **pass it as an input to another function**. The receiving function can then call it whenever it wants.

**You've already seen this in `practice_05`.** Simplified:

```js
function celsiusToFahrenheit(c) {
    return c * 9 / 5 + 32;
}

function sendResult(value, convert) {
    return convert(value);          // ← sendResult CALLS the function it was given
}

sendResult(20, celsiusToFahrenheit);   // 68
```

Follow it carefully:

1. You call `sendResult(20, celsiusToFahrenheit)`.
2. **No brackets** after `celsiusToFahrenheit`, so you're handing over the recipe, not running it.
3. Inside `sendResult`, the input `convert` now holds that recipe.
4. `sendResult` runs `convert(value)`, which is really `celsiusToFahrenheit(20)`.
5. So `c` is `20`, and it returns `68`.

**Who filled in `c`?** Not you. You never typed `celsiusToFahrenheit(20)`. **`sendResult` called it**, so `sendResult` filled in `c`. The golden rule from Step 2 still holds: *the caller fills in the inputs.* The caller just isn't you this time.

A function you hand over like this is called a **callback**: *"here's a function, call it back when you need it."*

### You've used callbacks before

```js
setTimeout(helloWorld, 3000);
```

You hand `helloWorld` (no brackets!) to `setTimeout`, and **`setTimeout` calls it** 3 seconds later.

> ⚠️ `setTimeout(helloWorld(), 3000)` **with** brackets is a bug. It runs `helloWorld` immediately and hands `setTimeout` its *result*, not the function.

---

## 8. ⭐ A function that calls your function many times

Here's a function that takes a list and a callback, and calls your callback **once for each item**:

```js
function askAboutEach(list, question) {
    for (const item of list) {
        const answer = question(item);        // ← calls YOUR function with each item
        console.log(item, '→', answer);
    }
}

function isLong(word) {
    return word.length > 3;
}

askAboutEach(['bob', 'tom', 'John'], isLong);
// bob → false
// tom → false
// John → true
```

`isLong` gets called **three times**. Each time, `askAboutEach` fills `word` with the next item. You never call `isLong` yourself.

---

## 9. ⭐ Writing the callback right inside the brackets

Instead of making `isLong` separately and passing its name, you can write the function **directly** where the name would go:

```js
// Separately, then pass the name:
function isLong(word) {
    return word.length > 3;
}
askAboutEach(['bob', 'tom', 'John'], isLong);

// Or written right in place, with no name:
askAboutEach(['bob', 'tom', 'John'], function(word) {
    return word.length > 3;
});

// Or as an arrow function:
askAboutEach(['bob', 'tom', 'John'], word => word.length > 3);
```

**All three are identical.** Same output, same behaviour. The in-place version just saves you from inventing a name for something you only use once.

### And that's `function(u)`

Now look at your line from `practice_04`:

```js
var user = users.find(function(u) {
    return u.id === req.params.id;
});
```

It's Step 9 exactly:

- `.find` is like `askAboutEach`: it goes through the list and **calls your function for each item**.
- `function(u) { ... }` is the callback, written in place, with no name.
- **`.find` fills in `u`**, one user at a time. That's the golden rule: the caller fills the inputs, and the caller is `.find`.
- `return u.id === req.params.id` hands back `true` or `false`: "is this the one?"

Lesson 04 shows exactly how `.find` uses that `true` / `false`.

---

## 10. Where variables live (scope)

Variables made **inside** `{ }` only exist inside those `{ }`:

```js
function test() {
    const secret = 42;
    console.log(secret);   // 42
}
test();
console.log(secret);       // ❌ error: secret doesn't exist out here
```

But an inner function **can** see variables from the outside:

```js
const wanted = '2';

users.find(function(u) {
    return u.id === wanted;   // ✅ can see `wanted` from outside
});
```

That's how the callback in `practice_04` can use `req.params.id`: it's inside the route function, so the callback can see it.

---

## ✏️ Try it

1. Write `square(n)` that returns `n * n`. Call it with `4`.
2. Write it again as a one-line arrow function.
3. Write `isEven(n)` that **returns a comparison** (hint: `%` from Lesson 01).
4. Write `twice(fn)` that **calls** `fn` two times. Test it with `twice(function() { console.log('hi'); })`.
5. Using `askAboutEach` from Step 8, write an **in-place** callback that asks whether each word starts with `'t'`. (Hint: `word[0]` is the first letter.)
6. **Explain in your own words:** in `askAboutEach(list, function(word) { ... })`, who gives `word` its value?

<details>
<summary>Answers (open after trying)</summary>

```js
// 1
function square(n) {
    return n * n;
}
console.log(square(4));   // 16

// 2
const square2 = n => n * n;

// 3
function isEven(n) {
    return n % 2 === 0;
}
console.log(isEven(4), isEven(7));   // true false

// 4
function twice(fn) {
    fn();
    fn();
}
twice(function() { console.log('hi'); });   // hi hi

// 5
askAboutEach(['bob', 'tom', 'John'], function(word) {
    return word[0] === 't';
});
// bob → false
// tom → true
// John → false
```

**6.** `askAboutEach` does. It calls the function once for each item in the list and puts that item into `word`. I write the function; `askAboutEach` calls it.
</details>

---

### ✅ Checklist: you're ready for Lesson 04 when you can...

- [ ] explain the golden rule: *who fills in a function's inputs?*
- [ ] explain `helloWorld` vs `helloWorld()`
- [ ] write the same function three ways: classic, in-place, arrow
- [ ] explain why `return a === b` returns `true` or `false`
- [ ] explain where `u` comes from in `users.find(function(u) { ... })`

If the last one still feels shaky, **stop here and ask** before moving on.
