package algorithms.named.bellman_ford;

import algorithms.Edge;
import algorithms.Graph;
import algorithms.greedy.GraphFactory;

import java.util.List;

public class Bellman_Ford_3 {
    public static void main(String[] args) throws Exception {
        Graph<String> graph = new GraphFactory().DirectedGraphFactory();
        
        // 1. Choose the source by set distance = 0
        int source = 0;
        
        // 2. Set distances to all other vertices = Integer.MAX
        graph.vertices.forEach(v -> v.setDistance(Integer.MAX_VALUE));
        
        // 3. Set the distance in the source vertex to 0
        graph.vertices.get(source).setDistance(0);
        
        List<Edge<String>> edges = graph.getEdges();
        
        for (int cycle = 0; cycle<graph.vertices.size(); cycle++){
            traverse(edges);
        }
        
        checkNegativeCycles(edges);

        System.out.println(graph);
    }
    
    private static void checkNegativeCycles(List<Edge<String>> edges) throws Exception {
        for (Edge<String> edge : edges){
            int updatedDistance = edge.getWeight() + edge.getFrom().getDistance();
            if (edge.getTo().getDistance() > updatedDistance){
                throw new Exception("The Graph contains negative cycles");
            }
        }
    }
    
    private static void traverse(List<Edge<String>> edges) {
        for (Edge<String> edge : edges){
            int updatedDistance = edge.getWeight() + edge.getFrom().getDistance();
            if (edge.getTo().getDistance() > updatedDistance){
                edge.getTo().setDistance(updatedDistance);
            }
        }
    }
}
