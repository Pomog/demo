package algorithms.named.kosaraju;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Kosaraju_Algorithm {
    private final int n;
    private final List<LinkedList<Integer>> graph;
    private boolean[] visited;
    private Stack<Integer> stack;
    
    public Kosaraju_Algorithm(List<LinkedList<Integer>> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph can not be Null");
        }
        this.graph = graph;
        this.n = graph.size();
    }
    
    private static List<LinkedList<Integer>> createGraph(int n) {
        List<LinkedList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<Integer>());
        }
        return graph;
    }
    
    public static void addEdge(List<LinkedList<Integer>> graph, int form, int to){
        graph.get(form).add(to);
    }
    
    public static void main(String[] args) {
        int n = 8;
        List<LinkedList<Integer>> graph = createGraph(n);
        
        addEdge(graph, 0,1);
        addEdge(graph, 1,2);
        addEdge(graph, 2,0);
        addEdge(graph, 2,3);
        addEdge(graph, 3,4);
        addEdge(graph, 4,7);
        addEdge(graph, 4,5);
        addEdge(graph, 6,4);
        addEdge(graph, 5,6);
        addEdge(graph, 6,7);
        
    }
}
