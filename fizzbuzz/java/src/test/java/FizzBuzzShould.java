
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzShould {

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "4,4"})
    void return_string_number_when_no_multiple_of_three_or_five(int input, String expected) {
        assertEquals(expected, new FizzBuzzer().convert(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12})
    void return_fizz_when_multiple_of_3(int input) {
        assertEquals("Fizz", new FizzBuzzer().convert(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    void return_fizz_when_multiple_of_5(int input) {
        assertEquals("Buzz", new FizzBuzzer().convert(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 25, 30})
    void return_fizz_buzz_when_multiple_of_3_and_5(){
        assertEquals("FizzBuzz", new FizzBuzzer().convert(15));
    }
}
