package algorithms.named;

import java.util.*;

// BFS
public class Ford_Fulkerson {
    public static void main(String[] args) {
        int[][] graph = {
                {0,3,2,0,0,0},
                {0,0,0,2,0,0},
                {0,3,0,0,3,0},
                {0,0,1,0,0,3},
                {0,0,0,3,0,2},
                {0,0,0,0,0,0}
        };
        
        getMaxFlow(graph, 0, graph.length-1);
    }
    
    private static void getMaxFlow(int[][] graph, int source, int sink) {
        int[][] residualGraph = Arrays.stream(graph)
                .map(int[]::clone) // Cloning each row
                .toArray(int[][]::new); // Collecting as a 2D array
        
        Map<Integer, Integer> parentMapping = new HashMap<>();
        List<List<Integer>> augmentingPaths = new ArrayList<>();
        
        while (getAugmentingPath(residualGraph, parentMapping, source,sink)){
            List<Integer> augPath = new ArrayList<>();
            int flow = Integer.MAX_VALUE;
            
            
        
        }
    }
    
    private static boolean getAugmentingPath(int[][] residualGraph, Map<Integer, Integer> parentMapping, int source, int sink) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited.add(source);
        
        boolean gotThePath = false;
        
        while (!queue.isEmpty()){
            int u = queue.poll();
            
            for(int v = 0; v<residualGraph.length; v++){
                if (!visited.contains(v) && residualGraph[u][v] > 0){
                    parentMapping.put(v,u);
                    visited.add(v);
                    
                    if (v==sink){
                        gotThePath=true;
                        break;
                    }
                }
            }
            return gotThePath;
        }
    }
    
}
