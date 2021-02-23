import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearShould {

    @ParameterizedTest
    @ValueSource(ints = {4, 8, 220, 1520})
    void return_true_if_divisible_by_four(int year) {
        assertTrue(new LeapYear().isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 500, 1990})
    void return_false_if_divisible_by_100(int year) {
        assertFalse(new LeapYear().isLeapYear(year));
    }

    @Test
    void return_true_if_divisible_by_4_not_by_100_but_by_400() {
        assertTrue(new LeapYear().isLeapYear(2000));
    }
}
