package algorithms.named.kosaraju;

import java.util.*;

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
    
    public void solve(){
        stack = new Stack<>();
        visited= new boolean[n];
        Arrays.fill(visited, false);
        
        // step 1. DFS and fill stack
        for (int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited);
            }
        }
        
        // reverse the Graph
        List<LinkedList<Integer>> reverseGraph = reverse();
    }
    
    private List<LinkedList<Integer>> reverse() {
        List<LinkedList<Integer>> reverseGraph = createGraph(n);
        
        for (int u=0; u<n; u++){
            for (Integer v : graph.get(u)) {
                addEdge(reverseGraph, v, u);
            }
        }
        
        return reverseGraph;
    }
    
    private void dfs(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        
        for (int to : graph.get(currentVertex)) {
            if (!visited[to]) {
                dfs(to, visited);
            }
        }
        
        stack.push(currentVertex);
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
