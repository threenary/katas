import { fizzbuzz } from "./fizzbuzz";

const fizz: string = "Fizz";
const buzz: string = "Buzz";

describe("FizzBuzz should", () => {
  test("Return the number received", () => {
    expect(fizzbuzz(1)).toBe("1");
  });
  test("Return Fizz if value is 3", () => {
    expect(fizzbuzz(3)).toBe(fizz);
  });
  test("Return Buzz if value is 5", () => {
    expect(fizzbuzz(5)).toBe(buzz);
  });
  test("Return Fizz when value multiple of 3", () => {
    expect(fizzbuzz(6)).toBe(fizz);
    expect(fizzbuzz(9)).toBe(fizz);
    expect(fizzbuzz(12)).toBe(fizz);
  });
  test("Return Fizz when value multiple of 5", () => {
    expect(fizzbuzz(10)).toBe(buzz);
    expect(fizzbuzz(20)).toBe(buzz);
  });
  test("Return FizzBuzz when value is multiple of 3 and 5", () => {
    expect(fizzbuzz(15)).toBe(`${fizz}${buzz}`);
  });
});
