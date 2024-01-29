package algorithms.recursive;

public class Factorial {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(calculateFactorial(n));
        System.out.println(calculateFibonacci(n));

    }

    /**
     * Calculates the Factorial of a given number recursively.
     * @param n The number for which Factorial is to be calculated.
     * @return The Factorial of the given number.
     */
    private static Integer calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    /**
     * Calculates the nth number in the Fibonacci series recursively.
     * @param n The index of the Fibonacci number to be calculated.
     * @return The nth Fibonacci number.
     */
    private static Integer calculateFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n < 0) {
            return -1; // Fibonacci series is not defined for negative numbers
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
