# Roman Numerals Kata

Write a program to convert Arabic numbers into their Roman numeral equivalents.

The Romans wrote their numbers using combinations of the following letters:

Decimal  |  Roman
--|--
1  | I
5  | V
10  | X
50  | L
100  | C
500  | D
1000  | M

## First Step

Initially, the Roman Numerals system consisted of expressing the number in terms of the most appropriate symbol that could be used.
8
To start, for the numbers 1-4, we would use the 'I' symbol in multiples to represent the number:

Decimal  | Roman
--|--
1  | I
2  | II
3  | III
4  | IIII
5  | V

When the numbers got to 5, we would use 'V' as this symbol was the most efficient way to represent the number.

For the single integers greater than 5, a new rule came into effect: when 'smaller' symbols are appended one or more times behind the 'larger' symbol, it is considered to be added to the value representing the larger symbol.

Decimal  | Roman
--|--
6 | VI
7  | VII
8  | VIII
9  | VIIII

## Second Step

However, as you may have noticed the numbers for 4 and 9 don't look right. But the original formation of the numerals was this (even some clock faces still display IIII for 4). But this created problems as people kept confusing III with IIII and VIII with VIIII an additional rule was developed.

For numbers such as 4 and 9, the smaller symbol (I) is prepended with the larger symbol (V or 5 for the number 4, and X representing 10 for the number 9). When the smaller symbol appears before the larger symbol, it is considered to be subtracted from the larger symbol.

So, 'IV' is evaluated as: V - I = 5 - 1 = 4 and 'IX' is evaluated as: X - I = 10 - 1 = 9

Hence, the list of Roman Numerals for 1 - 9 are as amended to:

Decimal  | Roman
--|--
1 | I
2 | II
3  | III
4  | IV
5  | V
6  | VI
7  | VII
8  | VIII
9  | IX


## Third Step
Because Roman system is follow a decimal notation system, the same rules apply for the next order up: units of 10.

In this case, use the symbol 'X' for 10

Decimal  | Roman
--|--
10 | X
11 | XI
12  | XII
13  | XIII
14  | XIV
15  | XV
16  | XVI
17  | XVII
18  | XVIII
19  | XIX

# Fourth Step
Extend the behavior using the symbol 'L' for fifty and 'C' for one hundred:

Decimal  | Roman
--|--
20 | XX
30 | XXX
40  | XL
50 | L
60  | LX
70  | LXX
80  | LXXX
90  | XC
100  | C

For the next decimal order up, use the same rules again with 'C' for 100, 'D' for 500 and 'M' for 1000

Decimal  | Roman
--|--
100 | C
200 | CC
300 | CCC
400 | CD
500 | D
600 | DC
700 | DCC
800 | DCCC
900 | CM
1000  | M

#Fifth Step
There were certain rules that the numerals followed which should be observed:

The 'base 1' symbols ('I', 'X', 'C', 'M') can be subtracted from the next highest 'base 5' symbol ('V', 'L', 'D') or 'base 1' symbol, but only one occurrence is allowed. The symbol cannot be prepended to a symbol that is the next decimal order higher. So 'IV', 'IX' is ok but 'IL' or 'IC' are not. 'XL', 'XC' is valid but XD and XM are not ('CD' and 'CM' are also valid)

The symbols 'I' and 'X' can be repeated at most 3 times in a row when the symbol is being appended

The 'base 5' symbols 'V', 'L' and 'D' can never be repeated

More examples:
Decimal  | Roman
--|--
4 | IV
9 | IX
29 | XXIX
40 | CL
49  | CLIX
294  | CXCIV
2019  | MMIX

## Tips
* Take small steps. You should always be able to go to a green state (with all tests passing) quickly.
* Stick to the red, green and refactor steps.
* Try not to refactor in the red. If you write a failing test that would need a big rewrite to pass, consider removing the test, refactoring in the green, and then writing the test again.
* As you progress through the problem, you should see your algorithm start to evolve. In other words, as the tests get more specific, the code gets more generic.
* Don't be afraid to let the code get a little bit messy - sometimes that's the best way to spot the next refactoring step.

## Further references
- [Codurance Katalyst](https://katalyst.codurance.com/roman-numerals "Codurance Katalyst")
- [Applying Transformation Priority Premise to Roman Numerals Kata](https://codurance.com/2015/05/18/applying-transformation-priority-premise-to-roman-numerals-kata/)
  
