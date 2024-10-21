package algorithms.named.tarjan_algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Tarjan_Algorithm {
    private static final int UNVISITED = -1;
    private int n;
    private int num;
    private boolean[] visited;
    private int[] dfsNum, dfsLow;
    private Stack<Integer> stack;
    private LinkedList<Integer>[] graph;
    
    public Tarjan_Algorithm(LinkedList<Integer>[] graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph can not be Null");
        }
        this.graph = graph;
        this.n = graph.length;
    }
    
    public static void main(String[] args) {
        int n = 7;
        LinkedList<Integer>[] graph = createGraph(n);
        
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 6);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 2);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 4);
        addEdge(graph, 6, 4);
        addEdge(graph, 6, 0);
        
        Tarjan_Algorithm sccSolver = new Tarjan_Algorithm(graph);
        System.out.println("Strongly connected components");
        sccSolver.solve();
      
    }
    
    private static void addEdge(LinkedList<Integer>[] graph, int from, int to) {
        graph[from].add(to);
    }
    
    private static LinkedList<Integer>[] createGraph(int n) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        return graph;
    }
    
    public void solve() {
        dfsNum = new int[n];
        dfsLow = new int[n];
        visited = new boolean[n];
        stack = new Stack<>();
        
        Arrays.fill(dfsNum, UNVISITED);
        
        for (int i = 0; i < n; i++) {
            if (dfsNum[i] == UNVISITED) {
                dfs(i);
            }
        }
    }
    
    private void dfs(int curr) {
        dfsNum[curr] = dfsLow[curr] = num++;
        stack.push(curr);
        visited[curr] = true;
        
        Iterator<Integer> i = graph[curr].iterator();
        while (i.hasNext()){
            int to = i.next();
            if (dfsNum[to] == UNVISITED){
                dfs(to);
            }
            if(visited[to]){
                dfsLow[curr]=Math.min(dfsLow[curr],dfsLow[to]);
            }
        }
        
        if(dfsNum[curr] == dfsLow[curr]){
            // popping out the nodes above current
            for (int node = stack.pop(); ;node = stack.pop()){
                visited[node]=false;
                System.out.print(node + " ");
                if(node == curr){
                    break;
                }
            }
            System.out.println();
        }
    }
}
