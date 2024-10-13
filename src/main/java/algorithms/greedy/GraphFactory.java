package algorithms.greedy;

import algorithms.Graph;
import algorithms.Vertex;

import java.util.List;

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
    
    public Graph<String> createUndirectedGraph() {
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
    
    public Graph<String> DirectedGraphFactory(){
        Graph<String> graph = new Graph<>();
        
        // Create vertices
        Vertex<String> v0 = new Vertex<>("0");
        Vertex<String> v1 = new Vertex<>("1");
        Vertex<String> v2 = new Vertex<>("2");
        Vertex<String> v3 = new Vertex<>("3");
        Vertex<String> v4 = new Vertex<>("4");
        Vertex<String> v5 = new Vertex<>("5");
        
        // Add vertices to the graph
        graph.vertices.addAll(List.of(v0, v1, v2, v3, v4, v5));
        
        // Create edges with weights (source, destination, weight)
        graph.addEdge(v0, v1, 8);   // AB
        graph.addEdge(v0, v5, 5);   // AF
        graph.addEdge(v0, v3, 3);   // AD
        graph.addEdge(v1, v2, 6);   // BC
        graph.addEdge(v2, v4, 4);   // CE
        graph.addEdge(v3, v4, -1);  // DE
        graph.addEdge(v5, v1, -4);  // FB
        graph.addEdge(v5, v2, -1);  // FC
        graph.addEdge(v5, v4, -3);  // FE
        
        return graph;
    }
    
    public Graph<String> DirectedGraphFactoryNegCycle(){
        Graph<String> graph = new Graph<>();
        
        // Create vertices
        Vertex<String> v0 = new Vertex<>("0");
        Vertex<String> v1 = new Vertex<>("1");
        Vertex<String> v2 = new Vertex<>("2");
        Vertex<String> v3 = new Vertex<>("3");
        Vertex<String> v4 = new Vertex<>("4");
        Vertex<String> v5 = new Vertex<>("5");
        
        // Add vertices to the graph
        graph.vertices.addAll(List.of(v0, v1, v2, v3, v4, v5));
        
        // Create edges with weights (source, destination, weight)
        graph.addEdge(v0, v1, 8);   // AB
        graph.addEdge(v0, v5, 5);   // AF
        graph.addEdge(v0, v3, 3);   // AD
        graph.addEdge(v1, v2, 6);   // BC
        graph.addEdge(v1, v0, -10);   // BA
        graph.addEdge(v2, v4, 4);   // CE
        graph.addEdge(v3, v4, -1);  // DE
        graph.addEdge(v5, v1, -4);  // FB
        graph.addEdge(v5, v2, -1);  // FC
        graph.addEdge(v5, v4, -3);  // FE
        
        return graph;
    }
}
