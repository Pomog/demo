package algorithms.graphs_udemy;

import java.util.ArrayList;

public class Graph {
    // Adjacency list
    private final ArrayList<Integer>[] graph;
    private final boolean[] visited;
    
    @SuppressWarnings("unchecked")
    Graph (int vertices) {
        graph = new ArrayList[vertices];
        visited = new boolean[vertices];
        
        for (int i = 0; i< vertices; i++){
            graph[i] = new ArrayList<Integer>();
        }
    }
   
    void addEdge (int src, int dest){
        graph[src].add(dest);
    }
    
    void dfsTraversal (int vertex){
        visited[vertex] = true;
        System.out.println(vertex);
        for (int adj : graph[vertex]) {
            if (!visited[adj]) {
                dfsTraversal(adj);
            }
        }
    }
    
    public static void main(String[] args) {
        Graph g = new Graph(13);
        
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 4);
        g.addEdge(2, 10);
        g.addEdge(2, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 7);
        g.addEdge(5, 2);
        g.addEdge(5, 8);
        g.addEdge(6, 9);
        g.addEdge(8, 11);
        g.addEdge(11, 12);
        
        System.out.println("DFS traversal, recursive");
        
        g.dfsTraversal(1);
        
    }
}
