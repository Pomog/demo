package algorithms.greedy;

import algorithms.named.Edge;

import java.util.Arrays;

public class BellmanFord {
    // number of vertices and edges
    int VERTICES, EDGES;
    Edge[] edge;
    
    public BellmanFord(int VERTICES, int EDGES) {
        this.VERTICES = VERTICES;
        this.EDGES = EDGES;
        edge = new Edge[EDGES];
        
        for (int i = 0; i < EDGES; i++) {
            edge[i] = new Edge();
        }
    }
    
    public static void main(String[] args) {
        BellmanFord graph = new BellmanFord(6 , 9);
// A=0, B=1, C=2, D=3, E=4, F=5
//        AB 01
        graph.edge[0].s = 0;
        graph.edge[0].d = 1;
        graph.edge[0].w = 8;
//        AF 05
        graph.edge[1].s = 0;
        graph.edge[1].d = 5;
        graph.edge[1].w = 5;
//        AD 03
        graph.edge[2].s = 0;
        graph.edge[2].d = 3;
        graph.edge[2].w = 3;
//        BC 12
        graph.edge[3].s = 1;
        graph.edge[3].d = 2;
        graph.edge[3].w = 6;
//        CE 24
        graph.edge[4].s = 2;
        graph.edge[4].d = 4;
        graph.edge[4].w = 4;
//        DE 34
        graph.edge[5].s = 3;
        graph.edge[5].d = 4;
        graph.edge[5].w = -1;
//        FB 51
        graph.edge[6].s = 5;
        graph.edge[6].d = 1;
        graph.edge[6].w = -4;
//        FC 52
        graph.edge[7].s = 5;
        graph.edge[7].d = 2;
        graph.edge[7].w = -1;
//        FE 54
        graph.edge[8].s = 5;
        graph.edge[8].d = 4;
        graph.edge[8].w = -3;
        
        bellmanFord(graph, 0);
    }
    
    private static void bellmanFord(BellmanFord graph, int source) {
        int[] distance = new int[graph.VERTICES];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        
//        Relax edges Vertices-1 times
        for (int i=0; i<graph.VERTICES; ++i){
            for (int j=0; j<graph.EDGES; ++j){
                int sourceVertex = graph.edge[j].s;
                int destVertex = graph.edge[j].d;
                int costVertex = graph.edge[j].w;
                
                if (
                    distance[sourceVertex] != Integer.MAX_VALUE
                            &&
                            (distance[sourceVertex] + costVertex < distance[destVertex])
                ){
                    distance[destVertex] = distance[sourceVertex] + costVertex;
                }
            }
        }
        
            for (int j=0; j<graph.EDGES; ++j){
                int sourceVertex = graph.edge[j].s;
                int destVertex = graph.edge[j].d;
                int costVertex = graph.edge[j].d;
                
                if (
                        distance[sourceVertex] != Integer.MAX_VALUE
                                &&
                                distance[sourceVertex] + costVertex < distance[destVertex]
                ){
                    System.out.println("The Graph contains negative cycle");
                }
            }
        
        for (int i =0; i<graph.VERTICES; i++){
            System.out.println(i + " : " + distance[i]);
        }
    }
}
