import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsCalculatorShould {

    @ParameterizedTest
    @MethodSource("sequenceSizeParametersProvider")
    void return_size_of_sequence(int[] sequence, int expected) {
        assertEquals(expected, new StatsCalculator().numberOfElements(sequence));
    }

    @ParameterizedTest
    @MethodSource("averageParametersProvider")
    void return_average_elements_in_the_sequence(int[] sequence, double expected) {
        assertEquals(expected, new StatsCalculator().average(sequence));
    }

    @ParameterizedTest
    @MethodSource("maximumParametersProvider")
    void return_maximum_element_when_unique_value(int[] sequence, int expected) {
        assertEquals(expected, new StatsCalculator().maximum(sequence));
    }

    @ParameterizedTest
    @MethodSource("minumumParametersProvider")
    void return_minumum_element_when_unique_value(int[] sequence, int expected) {
        assertEquals(expected, new StatsCalculator().minimum(sequence));
    }

    @Test
    void return_sequence_statistics() {
        Statistics expected = new Statistics.StatsBuilder()
                .setSize(5)
                .setAverage(30)
                .setMaximum(50)
                .setMinimum(10)
                .build();

        int[] sequence = {10, 20, 30, 40, 50};

        assertEquals(expected, new StatsCalculator().stats(sequence));
    }

    private static Stream<Arguments> minumumParametersProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{1, 2, 3}, 1));
    }

    private static Stream<Arguments> maximumParametersProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 2, 3}, 3));
    }

    private static Stream<Arguments> averageParametersProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 1.5),
                Arguments.of(new int[]{1, 2, 3}, 2));
    }

    private static Stream<Arguments> sequenceSizeParametersProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 2, 3}, 3));
    }
}
