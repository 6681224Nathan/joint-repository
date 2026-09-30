# Lesson 05: Classes

← [Arrays and objects](04-arrays-and-objects.md) · Next: [Modules](06-modules.md) →

> **Goal:** make a **blueprint** for objects, then build as many objects from it as you like. This lesson uses your `practice_01` code.

---

## 1. Why classes?

In Lesson 04 you wrote objects by hand:

```js
const glass = { name: 'Glass', price: 120 };
const mug   = { name: 'Mug',   price: 90 };
```

That's fine for two. But if every product also needs a way to describe itself, format its price, and so on, you'd repeat all of it for every product. A **class** is a blueprint: describe it once, then stamp out objects from it.

It's the same idea as classes in Java, which you already know from your paradigm course.

---

## 2. A basic class

```js
class Product {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }

    describe() {
        return `Product: ${this.name} - ฿${this.price}`;
    }
}

const p = new Product('Glass', 120);
console.log(p.name);         // Glass
console.log(p.describe());   // Product: Glass - ฿120
```

| Part | Meaning |
|---|---|
| `class Product` | the blueprint's name. Capital letter by convention |
| `constructor(name, price)` | runs **once**, automatically, when you build an object with `new` |
| `this` | **"the object being built / used right now"** |
| `this.name = name` | store the input on the object |
| `describe() { ... }` | a **method**: a function that belongs to every object from this class |
| `new Product('Glass', 120)` | build an object from the blueprint. The inputs go to `constructor` |

### What is `this`?

When you do `new Product('Glass', 120)`, the constructor runs with `this` meaning **that new glass object**. So `this.name = name` means "give this glass a `name` of `'Glass'`".

Later, `p.describe()` runs `describe` with `this` meaning **`p`**. So `this.name` inside it is `p`'s name.

```js
const a = new Product('Glass', 120);
const b = new Product('Mug', 90);

a.describe();   // this = a → 'Product: Glass - ฿120'
b.describe();   // this = b → 'Product: Mug - ฿90'
```

One blueprint, two objects, each with its own data.

---

## 3. Getters: a method that looks like a value

From your `practice_01`:

```js
class Product {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }

    get formattedPrice() {
        return `฿${this.price.toFixed(2)}`;
    }
}

const p = new Product('Glass', 120);
console.log(p.formattedPrice);   // ฿120.00   ← NO brackets
```

The word **`get`** in front makes it act like a normal value. You write `p.formattedPrice`, **not** `p.formattedPrice()`. It's still worked out fresh every time you read it, so if `price` changes, `formattedPrice` changes too.

Use `get` for things that feel like **properties** of the object ("its formatted price") rather than **actions** ("describe yourself").

---

## 4. `extends`: a class based on another class

A discounted product **is** a product, just with a discount. Instead of rewriting everything, **extend** it.

First, the full `Product` from your `practice_01`, which combines steps 2 and 3. Note that `describe` now uses the getter:

```js
class Product {
    constructor(name, price) {
        this.name = name;
        this.price = price;
    }

    get formattedPrice() {
        return `฿${this.price.toFixed(2)}`;
    }

    describe() {
        return `Product: ${this.name} - ${this.formattedPrice}`;
    }
}
```

Now the class built on top of it:

```js
class DiscountedProduct extends Product {
    constructor(name, price, discountPercent) {
        super(name, price);                     // ① let Product set up name & price
        this.discountPercent = discountPercent; // ② then add the new part
    }

    get discountedPrice() {
        return this.price * (1 - this.discountPercent / 100);
    }

    describe() {                                // ③ replace Product's describe
        return `${super.describe()} (${this.discountPercent}% off → ฿${this.discountedPrice.toFixed(2)})`;
    }
}
```

| Part | Meaning |
|---|---|
| `extends Product` | "start with **everything** `Product` has" |
| `super(name, price)` | run **`Product`'s constructor**. Must come **before** you use `this` |
| a method with the **same name** (`describe`) | **replaces** the parent's version for this class |
| `super.describe()` | "run the **parent's** `describe` too", so you can build on it |

```js
const d = new DiscountedProduct('Glass', 120, 20);

d.name;               // 'Glass'           ← from Product
d.formattedPrice;     // '฿120.00'         ← from Product
d.discountedPrice;    // 96                ← new in DiscountedProduct
d.describe();
// 'Product: Glass - ฿120.00 (20% off → ฿96.00)'
```

`d.describe()` runs `DiscountedProduct`'s version, which calls `super.describe()` to get `Product: Glass - ฿120.00`, then adds the discount part on the end.

> ⚠️ In a class that `extends`, you **must** call `super(...)` in the constructor **before** using `this`. Otherwise JavaScript throws an error.

---

## 5. Classes vs plain objects: when to use which

| Use a... | When |
|---|---|
| plain object `{ }` | just holding data, like a user from `users.json` |
| class | many objects share the **same behaviour** (methods), like products that can describe themselves |

In your server labs you'll mostly use plain objects and arrays. Classes appear in the ES6 lessons and in `practice_02`'s `Calculator`.

---

## ✏️ Try it

1. Write a `class Student` with a constructor taking `name` and `score`.
2. Add a method `result()` that returns `'pass'` if `score >= 50`, otherwise `'fail'`.
3. Add a **getter** `grade` that returns `'A'` for 80+, `'B'` for 70+, otherwise `'C'`.
4. Make two students and print each one's `result()` and `grade`.
5. Write `class Exchange extends Student`, adding a `country` input. Override `result()` so it returns the parent's result plus ` (exchange from <country>)`.

<details>
<summary>Answers (open after trying)</summary>

```js
// 1–3
class Student {
    constructor(name, score) {
        this.name = name;
        this.score = score;
    }

    result() {
        return this.score >= 50 ? 'pass' : 'fail';
    }

    get grade() {
        if (this.score >= 80) return 'A';
        if (this.score >= 70) return 'B';
        return 'C';
    }
}

// 4
const s1 = new Student('Pin', 85);
const s2 = new Student('Bob', 40);
console.log(s1.result(), s1.grade);   // pass A
console.log(s2.result(), s2.grade);   // fail C

// 5
class Exchange extends Student {
    constructor(name, score, country) {
        super(name, score);
        this.country = country;
    }

    result() {
        return `${super.result()} (exchange from ${this.country})`;
    }
}

const e = new Exchange('Ana', 75, 'Spain');
console.log(e.result());   // pass (exchange from Spain)
console.log(e.grade);      // B   ← getter inherited from Student
```
</details>

---

### ✅ Checklist: you're ready for Lesson 06 when you can...

- [ ] explain what `constructor` and `new` do
- [ ] explain what `this` means inside a method
- [ ] explain why `p.formattedPrice` has no brackets
- [ ] explain what `super(...)` and `super.describe()` do
- [ ] read `practice_01/inclass01.js` top to bottom and predict its output
