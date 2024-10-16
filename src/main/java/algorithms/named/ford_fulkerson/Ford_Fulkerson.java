package algorithms.named.ford_fulkerson;

import java.util.*;

public class Ford_Fulkerson {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 2, 0, 0, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 3, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 3},
                {0, 0, 0, 3, 0, 2},
                {0, 0, 0, 0, 0, 0}
        };
        
        // Edmonds-Karp BFS
        getMaxFlow(graph, 0, graph.length);
    }
    
    private static void getMaxFlow(int[][] graph, int source, int sink) {
        
        int[][] residualGraph = Arrays.stream(graph)
                .map(int[]::clone)
                .toArray(int[][]::new);
        
        Map<Integer, Integer> parentMapping = new HashMap<>();
        List<List<Integer>> augmentingPaths = new ArrayList<List<Integer>>();
        

        
    }
    
    private static void print(int[][] graph) {
        Arrays.stream(graph)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    
    
}


