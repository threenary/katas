import { fizzbuzz } from "./fizzbuzz";

export const fizzbuzzer = (value: number): string => {
  let result = "";
  for (let index = 1; index <= value; index++) {
    result += fizzbuzz(index);
  }
  return result;
};
