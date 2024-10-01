package algorithms.greedy;

import algorithms.named.Edge;

public class BellmanFord {
    // number of vertices and edges
    int VERTICES, EDGES;
    Edge[] edges;
    
    public BellmanFord(int VERTICES, int EDGES) {
        this.VERTICES = VERTICES;
        this.EDGES = EDGES;
        edges = new Edge[EDGES];
        
        for (int i = 0; i < EDGES; i++) {
            edges[i] = new Edge();
        }
    }
    
    public static void main(String[] args) {
        BellmanFord graph = new BellmanFord(6 , 9);
// A=0, B=1, C=2, D=3, E=4, F=5
//        AB 01
        graph.edges[0].s = 0;
        graph.edges[0].d = 1;
        graph.edges[0].w = 8;
//        AF 05
        graph.edges[1].s = 0;
        graph.edges[1].d = 5;
        graph.edges[1].w = 5;
//        AD 03
        graph.edges[2].s = 0;
        graph.edges[2].d = 3;
        graph.edges[2].w = 3;
//        BC 12
        graph.edges[3].s = 1;
        graph.edges[3].d = 2;
        graph.edges[3].w = 6;
//        CE 24
        graph.edges[4].s = 2;
        graph.edges[4].d = 4;
        graph.edges[4].w = 4;
//        DE 34
        graph.edges[5].s = 3;
        graph.edges[5].d = 4;
        graph.edges[5].w = -1;
//        FB 51
        graph.edges[6].s = 5;
        graph.edges[6].d = 1;
        graph.edges[6].w = -4;
//        FC 52
        graph.edges[7].s = 5;
        graph.edges[7].d = 5;
        graph.edges[7].w = -1;
//        FE 54
        graph.edges[8].s = 5;
        graph.edges[8].d = 4;
        graph.edges[8].w = -3;
        
        
    }
}
