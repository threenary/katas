import java.util.Arrays;

public class StatsCalculator {
    public int numberOfElements(int[] sequence) {
        return sequence.length;
    }

    public double average(int[] sequence) {
        double sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
        }
        return sum / sequence.length;
    }

    public int maximum(int[] sequence) {
        Arrays.sort(sequence);
        return sequence[sequence.length - 1];
    }

    public int minimum(int[] sequence) {
        Arrays.sort(sequence);
        return sequence[0];
    }

    public Statistics stats(int[] sequence) {
        return new Statistics.StatsBuilder()
                .setAverage(average(sequence))
                .setMaximum(maximum(sequence))
                .setMinimum(minimum(sequence))
                .setSize(numberOfElements(sequence))
                .build();
    }
}
