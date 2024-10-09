package algorithms.named.dijkstra;

import algorithms.Graph;
import algorithms.greedy.GraphFactory;

public class Dijkstra_4 {
    public static void main(String[] args) {
        Graph<String> graph = new GraphFactory().createDirectedGraph();

        // 1. Choose the source by set distance = 0
        int source = 0;
        
        // 2. Set distances to all other vertices = Integer.MAX
        graph.vertices.parallelStream()
                .forEach(v -> v.setDistance(Integer.MAX_VALUE));
        
        // 3. Set the distance in the source vertex to 0
        graph.vertices.get(source).setDistance(0);
        
        
        
        System.out.println(graph);
        
        System.out.println(graph.getUnvisitedVertexWithSmallestDistance());
    }
}
