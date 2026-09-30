// ============================================================
//  2-async-await.js  —  The SAME buzzers, written with async/await
//  Run it with:   node 2-async-await.js
// ============================================================

const start = Date.now();
const log = (msg) => console.log(`[${String(Date.now() - start).padStart(4)}ms] ${msg}`);

// Our little shop. Same as before: resolve() = press the buzzer.
function makeCoffee() {
  return new Promise((resolve) => {
    setTimeout(() => resolve('☕ latte'), 1000);   // buzzer rung after 1s
  });
}
function makeToast() {
  return new Promise((resolve) => {
    setTimeout(() => resolve('🍞 toast'), 1000);  // buzzer rung after 1s
  });
}
function makeTea() {
  return new Promise((resolve, reject) => {
    setTimeout(() => reject(new Error('out of tea')), 500);   // fails
  });
}


// ------------------------------------------------------------
// PART 1 — await = "nap until the buzzer rings, then unwrap it"
// ------------------------------------------------------------

async function breakfast() {
  log('  breakfast: ordering coffee...');

  const coffee = await makeCoffee();   // 😴 nap here until it rings
  //    ^^^^^^ a real string, NOT a promise. await unwrapped the box.

  log(`  breakfast: got ${coffee}`);

  const toast = await makeToast();     // 😴 nap again
  log(`  breakfast: got ${toast}`);

  return `${coffee} + ${toast}`;       // this gets wrapped in a Promise!
}


// ------------------------------------------------------------
// PART 2 — the nap is LOCAL: the rest of the program keeps going
// ------------------------------------------------------------

log('main: calling breakfast()');
const result = breakfast();            // starts, hits await, naps, returns a BOX
console.log('main: breakfast() gave me:', result);   // Promise { <pending> }
log('main: I did NOT wait. Carrying on!');
log('main: doing other work...');


// ------------------------------------------------------------
// PART 3 — async ALWAYS returns a promise, so the caller awaits too
// ------------------------------------------------------------

async function main() {
  const meal = await result;           // unwrap breakfast's box
  log(`main: breakfast finally done => ${meal}`);

  // PART 4 — errors: try/catch instead of .catch()
  try {
    const tea = await makeTea();       // this one rejects
    log(`main: got ${tea}`);           // never runs
  } catch (err) {
    log(`main: caught it — ${err.message}`);
  }

  // PART 5 — the gotcha: one at a time vs all at once
  log('--- one at a time (await, await) ---');
  const t1 = Date.now();
  await makeCoffee();
  await makeToast();
  log(`took ${Date.now() - t1}ms`);     // ~2000ms

  log('--- all at once (Promise.all) ---');
  const t2 = Date.now();
  await Promise.all([makeCoffee(), makeToast()]);
  log(`took ${Date.now() - t2}ms`);     // ~1000ms
}
main();


// ------------------------------------------------------------
// PART 6 — proof that async wraps the return value
// ------------------------------------------------------------

function plain()       { return 'hello'; }
async function fancy() { return 'hello'; }

console.log('\nplain() returns :', plain());   // hello
console.log('fancy() returns :', fancy());     // Promise { 'hello' }
