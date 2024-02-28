package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Class to find the optimal schedule of intervals using greedy algorithm.
 */
public class IntervalScheduling {
    
    /**
     * Main method to test the IntervalScheduling class.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Input intervals
        int[][] intervals = {
                {0, 3},
                {0, 15},
                {7, 12},
                {11, 16},
                {12, 14},
                {16, 20},
        };
        
        // Find the optimal schedule
        List<int[]> optimalSchedule = schedule(intervals);
        
        // Print the optimal schedule
        System.out.println("Optimal Schedule:");
        for (int[] interval : optimalSchedule) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
    
    /**
     * Method to find the optimal schedule of intervals.
     * @param intervals the array of intervals
     * @return the list of intervals in the optimal schedule
     */
    private static List<int[]> schedule(int[][] intervals) {
        List<int[]> optimalIntervalSet = new ArrayList<>();
        
        // Sort intervals by finish time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        
        // Initialize last finish time
        int lastFinishTime = Integer.MIN_VALUE;
        
        // Iterate through sorted intervals
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start > lastFinishTime) {
                int end = interval[1];
                
                // Add interval to optimal schedule
                optimalIntervalSet.add(interval);
                
                // Update last finish time
                lastFinishTime = end;
            }
        }
        return optimalIntervalSet;
    }
}
