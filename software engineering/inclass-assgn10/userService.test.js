// userService.test.js
const { fetchUser, saveUser, clearDatabase } = require('./userService');
describe('User Service (Async Operations)', () => {
// Lifecycle hook: runs before every single test in this block
beforeEach(() => {
clearDatabase();
});
test('should resolve with user data when user exists', async () => {
// Arrange
const mockUser = { id: 1, name: 'Alice' };
saveUser(mockUser);
// Act
const user = await fetchUser(1);
// Assert
expect(user).toEqual(mockUser); // toEqual checks for deep object equality
});
test('should reject with an error when user does not exist', async () => {
// Asserting an asynchronous rejection
await expect(fetchUser(99)).rejects.toThrow("User not found");
});
});