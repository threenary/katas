# Bank Kata
 
Create a simple bank application with the following features:

     - Deposit into Account
     - Withdraw from an Account
     - Print a bank statement to the console
 
## Acceptance Criteria

Statement should have transactions in the following format:

```
  DATE       | AMOUNT  | BALANCE
  10/04/2014 | 500.00  | 1400.00
  02/04/2014 | -100.00 | 900.00
  01/04/2014 | 1000.00 | 1000.00
```

## Starting point and constraints

Start with the following interface that you are not allowed to change, nor extend:

    public class Account {

        public void deposit(int amount);

        public void withdrawal(int amount);

        public void printStatement();

    }

**NOTE:** Keep the exercise simple, you can use _int_ for money and _String_ for dates, and don´t get crazy with the ignore the formatting of the statement (spaces between pipes and words, etc).

## Further references
[Codrace - Katalyst: Bank][1e383c87]

  [1e383c87]: https://katalyst.codurance.com/bank "Codurance - Katalyst Bank"
