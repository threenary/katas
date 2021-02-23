import { fizzbuzzer } from "./fizzbuzzer";

describe("Fizzbuzzer should", () => {
  test("Return a string containing 1", () => {
    expect(fizzbuzzer(1)).toBe("1");
  });
  test("Return a string cotaining 1 2", () => {
    expect(fizzbuzzer(2)).toBe("12");
  });
  test("Return a string cotaining 1 2 Fizz", () => {
    expect(fizzbuzzer(3)).toBe("12Fizz");
  });
  test("Return a string cotaining 1 2 Fizz 4 Buzz", () => {
    expect(fizzbuzzer(5)).toBe("12Fizz4Buzz");
  });
});
