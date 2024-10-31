package algorithms.named.kosaraju;

import algorithms.named.base.Vertex;

public class KosarajuDemo_2 {
    public static void main(String[] args) {
        Vertex<String> v0 = new Vertex<>(0, "0");
        Vertex<String> v1 = new Vertex<>(1, "1");
        Vertex<String> v2 = new Vertex<>(2, "2");
        Vertex<String> v3 = new Vertex<>(3, "3");
        Vertex<String> v4 = new Vertex<>(4, "4");
        Vertex<String> v5 = new Vertex<>(5, "5");
        Vertex<String> v6 = new Vertex<>(6, "6");
        Vertex<String> v7 = new Vertex<>(7, "7");
        Vertex<String> v8 = new Vertex<>(8, "8");
        Vertex<String> v9 = new Vertex<>(9, "9");
        Vertex<String> v10 = new Vertex<>(10, "10");
        Vertex<String> v11 = new Vertex<>(11, "11");
        
        Graph<String> graph = new Graph<>();
        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);
        graph.addVertex(v10);
        graph.addVertex(v11);
        
        graph.addEdge(v0, v7);
        
        graph.addEdge(v1, v9);
        
        graph.addEdge(v2, v9);
        graph.addEdge(v2, v10);
        
        graph.addEdge(v3, v8);
        
        graph.addEdge(v4, v2);
        
        graph.addEdge(v5, v10);
        graph.addEdge(v5, v3);
        
        graph.addEdge(v6, v0);
        graph.addEdge(v6, v1);
        graph.addEdge(v6, v4);
        
        graph.addEdge(v7, v6);
        graph.addEdge(v7, v1);
        
        graph.addEdge(v8, v5);
        
        graph.addEdge(v9, v4);
        
        graph.addEdge(v10, v8);
        
        graph.addEdge(v11, v9);
        graph.addEdge(v11, v2);
        graph.addEdge(v11, v5);
        
        KosarajuAlgorithm<String> kosarajuAlgorithm = new KosarajuAlgorithm<>(graph);
        kosarajuAlgorithm.printStronglyConnectedComponents();
    }
}
