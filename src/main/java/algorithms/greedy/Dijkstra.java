package algorithms.greedy;

/**
 * Implementation of Dijkstra's algorithm to find the shortest paths from a source vertex to all other vertices
 */
public class Dijkstra {
    public static void main(String[] args) {
        // Example adjacency matrix representing the graph
        int[][] adjacencyMatrix  = new GraphFactory().createAdjacencyMatrix();
        
        dijkstra(adjacencyMatrix);
    }
    
    /**
     * Method to find the shortest paths from a source vertex to all other vertices using Dijkstra's algorithm
     * @param adjacencyMatrix The adjacency matrix representing the graph
     */
    private static void dijkstra(int[][] adjacencyMatrix) {
        int v = adjacencyMatrix.length; // Number of vertices
        boolean [] visited = new boolean[v]; // Array to track visited vertices
        int [] distance = new int[v]; // Array to store shortest distances
        
        distance[0] = 0; // Distance to source vertex is 0
        
        // Initialize distances to all other vertices as infinity
        for (int i = 1; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        
        // Iterate over all vertices - 1 times
        for (int i = 0; i < v - 1; i++) {
            // Find the vertex with the minimum distance that hasn't been visited yet
            int minVertex = findMinVertex(distance, visited);
            
            visited[minVertex] = true; // Mark the vertex as visited
            
            // Update the distances of adjacent vertices if a shorter path is found
            for (int j = 0; j < v; j++) {
                if (adjacencyMatrix[minVertex][j] != 0 && !visited[j]) {
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j]) {
                        distance[j] = newDist;
                    }
                }
            }
        }
        
        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < v; i++) {
            System.out.printf("%d %d\n", i, distance[i]);
        }
    }
    
    /**
     * Method to find the vertex with the minimum distance that hasn't been visited yet
     * @param distance Array containing the shortest distances to vertices
     * @param visited Array indicating whether vertices have been visited
     * @return The index of the vertex with the minimum distance
     */
    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        
        // Iterate over all vertices
        for (int i = 0; i < distance.length; i++) {
            // If the vertex hasn't been visited and either it's the first unvisited vertex or its distance is less than the current minimum distance
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i; // Update the index of the minimum vertex
            }
        }
        
        return minVertex;
    }
}
