public class Fibonacci {

    public int getFibonacci(int position) {
        if (position <= 1){
            return position;
        }
        return getFibonacci(position-1) + getFibonacci(position-2);
    }

}
