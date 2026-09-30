// ============================================================
//  1-buzzer.js  —  How a Promise is BUILT and how it gets RUNG
//  Run it with:   node 1-buzzer.js
// ============================================================

// A little helper so we can see WHEN each line happens.
const start = Date.now();
const log = (msg) => console.log(`[${String(Date.now() - start).padStart(4)}ms] ${msg}`);


// ------------------------------------------------------------
// PART 1 — Building a buzzer by hand
// ------------------------------------------------------------
//
// `new Promise(...)` hands you TWO functions: resolve and reject.
// They are the two buttons on the buzzer.
//
//    resolve(value)  =  press the buzzer, coffee is ready  ✅
//    reject(error)   =  tell them we're out of milk        ❌
//
// Nobody presses them for you. YOU decide when.

function makeCoffee(seconds) {
  log('barista: order received, starting the machine...');

  return new Promise((resolve, reject) => {
    // This code runs IMMEDIATELY. The promise starts "pending".

    setTimeout(() => {
      // ...and this runs LATER, when the coffee is done.
      log('barista: *** PRESSES THE BUZZER *** 🔔');
      resolve('☕ one latte');        // <-- THE BUZZER IS RUNG HERE
    }, seconds * 1000);
  });
}


// ------------------------------------------------------------
// PART 2 — Holding the buzzer, and listening to it
// ------------------------------------------------------------

const buzzer = makeCoffee(2);

console.log('you are holding:', buzzer);   // Promise { <pending> } — not coffee!

// .then() = "when the buzzer rings, run this"
buzzer.then((coffee) => {
  log(`you: buzzer rang! I collect ${coffee}`);
});

log('you: meanwhile I sit down and read my phone');
log('you: still reading...');


// ------------------------------------------------------------
// PART 3 — When it goes wrong: reject()
// ------------------------------------------------------------

function makeTea(seconds) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      log('barista: sorry, no tea leaves left 😖');
      reject(new Error('out of tea'));   // <-- THE FAILURE BUTTON
    }, seconds * 1000);
  });
}

makeTea(3)
  .then((tea) => log(`you: got ${tea}`))          // skipped — it rejected
  .catch((err) => log(`you: bad news — ${err.message}`));
