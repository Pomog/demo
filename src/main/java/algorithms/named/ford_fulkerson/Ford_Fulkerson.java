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
        System.out.println("The max flow is: " + getMaxFlow(graph, 0, graph.length-1));
    }
    
    private static int getMaxFlow(int[][] graph, int source, int sink) {
        
        int[][] residualGraph = Arrays.stream(graph)
                .map(int[]::clone)
                .toArray(int[][]::new);
        
        Map<Integer, Integer> parentMapping = new HashMap<>();
        List<List<Integer>> augmentingPaths = new ArrayList<List<Integer>>();
        
        int maxFlow = 0;
        while (getAugmentingPath(residualGraph, parentMapping, source, sink)) {
            List<Integer> augPath = new ArrayList<>();
            int flow = Integer.MAX_VALUE;
            
            int v = sink;
            while (v != source) {
                augPath.add(v);
                int u = parentMapping.get(v);
                
                if (flow > residualGraph[u][v]) {
                    flow = residualGraph[u][v];
                }
                v = u;
            }
            
            augPath.add(source);
            
            // reverse
            Collections.reverse(augPath);
            augmentingPaths.add(augPath);
            
            maxFlow += flow;
            
            v = sink;
            
            while (v != source) {
                int u = parentMapping.get(v);
                
                residualGraph[u][v] -= flow;
                residualGraph[v][u] += flow;
                
                v = u;
            }
        }
        printAugmentingPaths(augmentingPaths);
        return maxFlow;
    }
    
    private static void printAugmentingPaths(List<List<Integer>> augmentingPaths) {
        augmentingPaths.forEach(path -> {
            path.forEach(e -> System.out.print(e + " "));
            System.out.println();
        });
    }
    
    private static boolean getAugmentingPath(int[][] residualGraph, Map<Integer, Integer> parentMapping, int source, int sink) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited.add(source);
        
        boolean gotThePath = false;
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < residualGraph.length; v++) {
                if (!visited.contains(v) && residualGraph[u][v] > 0) {
                    parentMapping.put(v, u);
                    visited.add(v);
                    queue.add(v);
                    
                    if (v == sink) {
                        gotThePath = true;
                        break;
                    }
                }
            }
        }
        return gotThePath;
    }
    
    private static void print(int[][] graph) {
        Arrays.stream(graph)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    
    
}


