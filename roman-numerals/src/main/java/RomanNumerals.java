public class RomanNumerals {

    public String convert(int number) {
        StringBuilder output = new StringBuilder();

        for (RomanToDecimal rtd : RomanToDecimal.values()) {
            while (number >= rtd.decimal) {
                output.append(rtd.roman);
                number -= rtd.decimal;
            }
        }
        return output.toString();
    }

    enum RomanToDecimal {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FOURTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private int decimal;
        private String roman;

        RomanToDecimal(int i, String x) {
            decimal = i;
            roman = x;
        }
    }
}
