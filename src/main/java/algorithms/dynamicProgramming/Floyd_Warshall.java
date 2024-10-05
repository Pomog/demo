package algorithms.dynamicProgramming;

import java.util.Arrays;

public class Floyd_Warshall {
    public static int INF = 9999, V = 4;
    
    public static void main(String[] args) {
        int graph[][] = {
                {0, 3, INF, 2},
                {4, 0, 6, 7},
                {INF, 5, 0, INF},
                {INF, INF, 1, 0}
        };
        
        floydWarshall(graph);
    }
    
    private static void floydWarshall(int[][] graph) {
        int[][] dist = Arrays.copyOf(graph, V);

//      set each vertex as intermediate
        for (int k = 0; k < V; k++) {
//          each vertex as source
            for (int i = 0; i < V; i++) {
//              each vertex as destination
                for (int j = 0; j < V; j++) {
//                  shortest distance
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
