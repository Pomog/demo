package algorithms.greedy;

import algorithms.Graph;
import algorithms.Vertex;

/**
 * Factory class to create an adjacency matrix for graph algorithms.
 */
public class GraphFactory {
    
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
    
    public Graph<String> createDirectedGraph() {
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");
        Vertex<String> F = new Vertex<>("F");
        Vertex<String> G = new Vertex<>("G");
        
        Graph<String> graph = new Graph<>();
        graph.vertices.add(A);
        graph.vertices.add(B);
        graph.vertices.add(C);
        graph.vertices.add(D);
        graph.vertices.add(E);
        graph.vertices.add(F);
        graph.vertices.add(G);
        
        graph.addEdge(A, B, 3);
        graph.addEdge(A, C, 5);
        graph.addEdge(A, D, 6);
        graph.addEdge(A, F, 8);
        
        graph.addEdge(B, A, 3);
        graph.addEdge(B, D, 4);
        graph.addEdge(B, E, 2);
        graph.addEdge(B, G, 5);
        
        graph.addEdge(C, A, 5);
        graph.addEdge(C, F, 4);
        
        graph.addEdge(D, A, 6);
        graph.addEdge(D, B, 4);
        graph.addEdge(D, F, 1);
        graph.addEdge(D, G, 6);
        
        graph.addEdge(E, B, 2);
        graph.addEdge(E, G, 10);
        
        graph.addEdge(F, A, 8);
        graph.addEdge(F, C, 4);
        graph.addEdge(F, D, 1);
        graph.addEdge(F, G, 8);
        
        graph.addEdge(G, B, 5);
        graph.addEdge(G, D, 6);
        graph.addEdge(G, E, 10);
        graph.addEdge(G, F, 8);
        
        return graph;
    }
}
