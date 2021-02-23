import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciShould {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "1,2", "2,3", "3,4", "5,5", "8,6", "13,7", "21,8"})
    void return_fibonacci_number_for_the_nth_position(int expected, int position) {
        assertEquals(expected, new Fibonacci().getFibonacci(position));
    }
}
