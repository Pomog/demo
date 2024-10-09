package algorithms.named.dijkstra;

import algorithms.greedy.GraphFactory;

import java.util.Arrays;

public class Dijkstra_3 {
    public static void main(String[] args) {
        int[][] adjacencyMatrix  = new GraphFactory().createAdjacencyMatrix();
        
        diikstra(adjacencyMatrix);
    }
    
    private static void diikstra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length;
        
        boolean[] visited = new boolean[v];
        int[] distance = new int[v];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        
        for (int i = 0; i < v - 1; i++){
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            
            for (int j = 0; j < v; j++){
                if (adjacencyMatrix[minVertex][j] !=0 && !visited[j]){
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]){
                        distance[j] = newDist;
                    }
                }
            }
        }
        
        for (int i = 0; i<v; i++){
            System.out.println(i + " : " + distance[i]);
        }

    }
    
    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        
        for (int i = 0; i < distance.length; i++){
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        
        return minVertex;
    }
}
