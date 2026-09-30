// 3-simple-buzzer.js  —  the smallest possible async/await example
// Run:  node 3-simple-buzzer.js

// STEP 1: MAKE a buzzer.
// new Promise gives you a button called resolve.
// Pressing resolve(...) = ringing the buzzer.
function orderCoffee() {
  console.log('Barista: making your coffee...');
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('Barista: 🔔 BUZZ!');
      resolve('☕ coffee');          // <-- the buzzer rings here
    }, 2000);                        // after 2 seconds
  });
}

// STEP 2: USE the buzzer.
// async  = this function is allowed to wait
// await  = wait here until the buzzer rings, then hand me what's inside
async function morning() {
  console.log('Me: I order a coffee');
  const drink = await orderCoffee();   // waits 2 seconds here
  console.log('Me: I got my', drink);
}

// STEP 3: START it.
morning();
console.log('(the rest of the program keeps running while I wait)');
