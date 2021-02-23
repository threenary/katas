public class FizzBuzzer {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String convert(int i) {
        if (isDivisibleBy(i,3) && isDivisibleBy(i,5)) {
            return FIZZ + BUZZ;
        }
        if (isDivisibleBy(i,3)) {
            return FIZZ;
        }
        if (isDivisibleBy(i,5)) {
            return BUZZ;
        }
        return String.valueOf(i);
    }

    private boolean isDivisibleBy(int number, int factor){
        return number % factor == 0;
    }
}
