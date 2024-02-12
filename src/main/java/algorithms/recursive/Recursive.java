package algorithms.recursive;

import java.util.List;

public class Recursive {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(calculateFactorial(n));
        System.out.println(calculateFibonacci(n));
        
        String exampleString = "ABC";
        System.out.println(getSubsequences(exampleString));

        towerOfHanoi(3, 'X', 'Y', 'Z');
        
        List<Object> list1 = List.of(2, 3);
        List<Object> list2 = List.of(2, 4);
        List<Object> list3 = List.of(list1, 1);
        List<Object> list4 = List.of(1, 2, list3);
        System.out.println(productSum(list4, 1));
    }

    /**
     * Calculates the Recursive of a given number recursively.
     * @param n The number for which Recursive is to be calculated.
     * @return The Recursive of the given number.
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

    /**
     * Solves the Tower of Hanoi problem for a given number of disks.
     *
     * @param n   The number of disk to be moved.
     * @param from The rod from which disks are to be moved.
     * @param to   The rod to which disks are to be moved.
     * @param aux  The auxiliary rod used for intermediate storage.
     */
    private static void towerOfHanoi (int n, char from, char to, char aux){
        if (n == 1){
            System.out.println("Moving the disk 1 from " + from + " to the " + to + " rod.");
        } else {
            towerOfHanoi(n - 1, from, aux, to);
            System.out.println("Moving the disk " + n + " from " + from + " to the " + to + " rod.");
            towerOfHanoi(n - 1, aux, to, from);
        }
    }

//                                                         towerOfHanoi(1, X, Y, Z)
//                             towerOfHanoi(2, X, Z, Y) ->
//                                                         towerOfHanoi(1, Y, Z, X)
// towerOfHanoi(3, X, Y, Z) ->
//                                                         towerOfHanoi(1, Z, X, Y)
//                             towerOfHanoi(2, Z, Y, X) ->
//                                                         towerOfHanoi(1, X, Y, Z)

    /**
     * Calculates the product sum of a nested list recursively.
     * Product sum is the sum of each element in the list multiplied by its depth.
     * @param list The nested list containing integers or nested lists.
     * @param depth The current depth of the nested list.
     * @return The product sum of the nested list.
     */
    private static int productSum(List<Object> list, int depth) {
        int sum = 0;
        for (Object obj : list) {
            if (obj instanceof List) {
                // Recursively calculate product sum for nested list
                sum += productSum((List<Object>) obj, depth + 1);
            } else {
                // Add integer value to sum
                sum += (int) obj;
            }
        }
        // Multiply sum by depth
        return sum * depth;
    }
}