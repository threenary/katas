import java.util.Objects;

public class Statistics {

    double average;
    int minimum;
    int maximum;
    int size;

    public Statistics(double average, int minimum, int maximum, int size) {
        this.average = average;
        this.minimum = minimum;
        this.maximum = maximum;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistics that = (Statistics) o;
        return Double.compare(that.average, average) == 0 &&
                minimum == that.minimum &&
                maximum == that.maximum &&
                size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(average, minimum, maximum, size);
    }

    public static class StatsBuilder{

        private double average;
        private int minimum;
        private int maximum;
        private int size;

        public StatsBuilder setAverage(double average){
            this.average = average;
            return this;
        }

        public StatsBuilder setMinimum(int minimum){
            this.minimum= minimum;
            return this;
        }

        public StatsBuilder setMaximum(int maximum){
            this.maximum = maximum;
            return this;
        }

        public StatsBuilder setSize(int size){
            this.size = size;
            return this;
        }

        public Statistics build(){
            return new Statistics(this.average, this.minimum, this.maximum, this.size);
        }

    }

}
