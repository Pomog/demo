package algorithms.greedy;

public class Dijkstra_Udemy {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = new GraphFactory().createAdjacencyMatrix();
        
        dijkstra(adjacencyMatrix);
    }
    
    private static void dijkstra(int[][] adjacencyMatrix) {
        
        int numberOfVertices = adjacencyMatrix.length;
        
        boolean[] visitedNodes = new boolean[numberOfVertices];
        
        int[] distances = new int[numberOfVertices];

//        set distance for source as 0
        distances[0] = 0;

//        set infinity distances to all other Nodes
        for (int i = 1; i < numberOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

//      find the vertex with Min distance
        for (int i = 0; i < numberOfVertices - 1; i++) {
            int vertexWithMinDistance = findMinVertex(distances, visitedNodes);
            
            visitedNodes[vertexWithMinDistance] = true;
            
            for (int j = 0; j < numberOfVertices; j++) {
                if (adjacencyMatrix[vertexWithMinDistance][j] != 0 && !visitedNodes[j]) {
                    int newDistance = distances[vertexWithMinDistance] + adjacencyMatrix[vertexWithMinDistance][j];
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                    }
                }
            }
        }
        
        for (int i=0; i<numberOfVertices; i++){
            System.out.println(i + " "+ distances[i]);
        }
    }
    
    private static int findMinVertex(int[] distances, boolean[] visitedNodes) {
        int vertexWithMinDistance = -1;
        
        for (int i = 0; i < distances.length; i++) {
            if (!visitedNodes[i] && (vertexWithMinDistance == -1 || distances[i] < distances[vertexWithMinDistance])) {
                vertexWithMinDistance = i;
            }
        }
        
        return vertexWithMinDistance;
        
    }
}
