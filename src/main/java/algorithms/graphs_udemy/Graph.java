package algorithms.graphs_udemy;

import java.util.*;

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

    void dfsTraversalIter (int vertex){
        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();

        stack.push(vertex);

        while (!stack.isEmpty()) {
            vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.println(vertex);
            }

            for (int v : graph[vertex]) {
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }

    }

    void bfsTraversal (int vertex){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            Iterator<Integer> iterator = graph[currentVertex].listIterator();
            while (iterator.hasNext()) {
                int nextVertex = iterator.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
            System.out.println("Current vertex: " + currentVertex);
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
        
//        System.out.println("DFS traversal, recursive");
//        g.dfsTraversal(1);
//
//        System.out.println("DFS traversal, iterative");
//        g.dfsTraversalIter(1);

        System.out.println("BFS traversal, iterative");
        g.bfsTraversal(1);
        
    }
}
