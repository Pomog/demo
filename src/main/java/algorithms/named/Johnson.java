package algorithms.named;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Johnson {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 7, 0, -2, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, -5, 0}
        };
        
        allPairShortestPath(graph);
    }
    
    private static void allPairShortestPath(int[][] graph) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph[u].length; v++) {
                if (graph[u][v] != 0) {
                    edges.add(List.of(u, v, graph[u][v]));
                }
            }
        }
        
        int[] distance = bellmanFord(edges, graph.length);
        
        // get new positive edges weights
        int[][] newGraph = new int[graph.length][graph[0].length];
        
        System.out.println("Modified Graph, after Bellman-Ford:");
        
        for (int u = 0; u<graph.length; u++){
            for (int v =0; v<graph[u].length; v++){
                if (graph[u][v] != 0){
                    newGraph[u][v] = distance[u] + graph[u][v] - distance[v];
                }
                System.out.print(newGraph[u][v] + " ");
            }
            System.out.println();
        }
        
//        Run Dijkstra for every vertex as source
        for (int src = 0; src < graph.length; src++){
            System.out.println("Shortest dist form vertex: " + src);
            dijkstra(graph, newGraph, src);
        }
    
    }
    
    private static void dijkstra(int[][] graph, int[][] newGraph, int src) {
        int V = newGraph.length;
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
//        source to source = 0
        distance[src] = 0;
        
        for(int i=0; i<V-1; i++){
            int minVertex = findMinVertex(distance,visited);
            
            visited[minVertex] = true;
            
            for (int j = 0; j<V; j++){
                if (graph[minVertex][j] != 0 && !visited[j]){
                    int newDist = distance[minVertex] + newGraph[minVertex][j];
                    
                    if (newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }
        
        for (int i = 0; i<V; i++){
            System.out.println(i + " " + distance[i]);
        }
    
    }
    
    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i =0; i<distance.length; i++){
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
    
    private static int[] bellmanFord(List<List<Integer>> edges, int length) {
//        add arbitrary source
        int[] dist = new int[length + 1];
        
        for (int vertex : dist) {
            dist[vertex] = Integer.MAX_VALUE;
        }
        
        dist[length] = 0;

//        add edges from source ot all the other vertices
        for (int i = 0; i < length; i++) {
            edges.add(List.of(length, i, 0));
        }
        
        for (int i = 0; i < length; i++) {
            for (List<Integer> li : edges) {
                int u = li.get(0);
                int v = li.get(1);
                int w = li.get(2);
                
                if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
//        remove arbitrary source
        return Arrays.copyOfRange(dist, 0, length);
    }
}
