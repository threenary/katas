const fizz = "Fizz";
const buzz = "Buzz";

export const fizzbuzz = (value: number): string => {
  if (multipleOf(3, value) && multipleOf(5, value)) return `${fizz}${buzz}`;
  if (multipleOf(3, value)) return fizz;
  if (multipleOf(5, value)) return buzz;

  return value.toString();
};

const multipleOf = (multiple: number, value: number) => value % multiple == 0;
