package algorithms.greedy;

/**
 * Factory class to create an adjacency matrix for graph algorithms.
 */
public class AdjMatrixFactory {
    
    // Method to create and return a predefined adjacency matrix.
    public int[][] createAdjacencyMatrix() {
        // Return a new 2D array representing the adjacency matrix
        return new int[][] {
                {0, 3, 5, 6, 0, 8, 0},
                {3, 0, 0, 4, 2, 0, 5},
                {5, 0, 0, 0, 0, 4, 0},
                {6, 4, 0, 0, 0, 1, 6},
                {0, 2, 0, 0, 0, 0, 10},
                {8, 0, 6, 1, 0, 0, 8},
                {0, 8, 0, 6, 10, 8, 0}
        };
    }
}
