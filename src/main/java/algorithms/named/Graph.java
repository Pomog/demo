package algorithms.named;

import java.util.*;

public class Graph {
    int V;
    List<List<Integer>> adj;
    
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }
    
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }
    
    public void topologicalSort() {
        int[] indegree = new int[V];
        
        for (int i = 0; i<V; i++){
            ArrayList<Integer> temp = (ArrayList<Integer>) adj.get(i);
            
            for(int vertex : temp ){
                indegree[vertex]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=0; i<indegree.length; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        
        int c = 0;
        
        Vector<Integer> linearOrder = new Vector<Integer>();
        while (!q.isEmpty()){
            int x = q.poll();
            linearOrder.add(x);
           
            for (Integer vertex : adj.get(x)){
                if (--indegree[vertex] == 0){
                    q.add(vertex);
                }
            }

            c++;
        }
        
        if (c != V){
            System.out.println("Graph contains cycle");
            return;
        }
        System.out.println("The Linear Order is :");
        for (int i : linearOrder){
            System.out.println(i + " ");
        }
        
    }
}
