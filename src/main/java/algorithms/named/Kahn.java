package algorithms.named;

public class Kahn {
    // for directed non-cyclical graph
    
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(3,1);
        g.addEdge(3,2);
        g.addEdge(3,4);
        
        g.topologicalSort();
    }
}
