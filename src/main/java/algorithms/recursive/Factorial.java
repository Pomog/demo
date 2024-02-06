package algorithms.recursive;

public class Factorial {
    public static void main(String[] args) {
        int n = 11;
//        System.out.println(calculateFactorial(n));
//        System.out.println(calculateFibonacci(n));
        System.out.println(getSubsequences("abc"));

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

    /**
     * Returns all possible subsequences from the input string.
     * @param word The input string from which subsequences are generated.
     * @return A string containing all possible subsequences of the input string.
     */
    private static String getSubsequences(String word){
        if (word.isEmpty()){
            return "";
        }

        char firstChar = word.charAt(0);

        // Recursive call to get the subsequences of the substring starting from index 1
        String rest = getSubsequences(word.substring(1));

        StringBuilder result = new StringBuilder();

        // Iterate over each subsequence in the rest and concatenate with the first character
        for (String subSequence : rest.split(",", -1)){
            // Append the first character of the word followed by the subsequence
            result.append(",").append(firstChar).append(subSequence);
            // Append the subsequence alone
            result.append(",").append(subSequence);
        }

        // Remove the leading comma before returning the result
        return  result.substring(1);


    }
}
