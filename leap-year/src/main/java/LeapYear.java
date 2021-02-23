public class LeapYear {

    public boolean isLeapYear(int i) {
        return isDivisibleBy(i, 4) &&
                (isNotDivisibleBy(i, 100) ||
                        (isDivisibleBy(i, 400)));
    }

    private boolean isNotDivisibleBy(int number, int factor) {
        return !isDivisibleBy(number, factor);
    }

    private boolean isDivisibleBy(int number, int factor) {
        return number % factor == 0;
    }


}
