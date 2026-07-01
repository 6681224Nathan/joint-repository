// calculator.test.js
const { add, divide } = require('./calculator');
describe('Calculator Operations', () => {

    // Test case 1: Addition
    test('adds 2 + 3 to equal 5', () => {
        expect(add(2, 3)).toBe(5);
    });

    // Test case 2: Division
    test('divides 6 by 2 to equal 3', () => {
        expect(divide(6, 2)).toBe(3);
    });
    // Test case 3: Exception Handling
    test('throws an error when dividing by zero', () => {
        expect(() => divide(10, 0)).toThrow("Cannot divide by zero");
    });
});