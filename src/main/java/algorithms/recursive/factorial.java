package algorithms.recursive;

public class factorial {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(calculateFactorial(n));
        System.out.println(calculateFibonacci(n));

    }

    private static Integer calculateFactorial (int n){
        if (n <= 1){
            return 1;
        }
        return n*calculateFactorial(n-1);
    }

    private static Integer calculateFibonacci(int n){

        if (n == 1 || n == 2){
            return 1;
        }

        if (n < 0){
            return -1;
        }
        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }
}
