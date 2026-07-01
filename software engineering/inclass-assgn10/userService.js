// userService.js
// Simulated in-memory database
let users = [];
function clearDatabase() {
users = [];
}
function fetchUser(id) {
return new Promise((resolve, reject) => {
setTimeout(() => {
const user = users.find(u => u.id === id);
if (user) {
resolve(user);
} else {
reject(new Error("User not found"));
}
}, 100); // Simulates network latency
});
}
function saveUser(user) {
users.push(user);
}
module.exports = { fetchUser, saveUser, clearDatabase };