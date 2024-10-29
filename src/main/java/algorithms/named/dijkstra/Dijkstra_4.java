package algorithms.named.dijkstra;

import algorithms.Edge;
import algorithms.Graph;
import algorithms.Vertex;
import algorithms.greedy.GraphFactory;

import java.util.List;

public class Dijkstra_4 {
    public static void main(String[] args) {
        Graph<String> graph = new GraphFactory().createUndirectedGraph();

        // 1. Choose the source by set distance = 0
        int source = 0;
        
        // 2. Set distances to all other vertices = Integer.MAX
        graph.vertices.parallelStream()
                .forEach(v -> v.setDistance(Integer.MAX_VALUE));
        
        // 3. Set the distance in the source vertex to 0
        graph.vertices.get(source).setDistance(0);
        
        // 4. ProcessEntity vertices until all are visited
        while (graph.notVisitedVerticesPresent()){
            Vertex<String> minVertex = graph.getUnvisitedVertexWithSmallestDistance();
            
            minVertex.setVisited(true);
            int distance = minVertex.getDistance();
            
            List<Edge<String>> edgesToNotVisitedVertex = graph.getNotVisitedEdgesOfVertex(minVertex);
            
            // 4. Update distances using stream
            edgesToNotVisitedVertex.stream()
                    .filter(edge -> edge.getTo().getDistance() > edge.getWeight() + distance)
                    .forEach(edge -> edge.getTo().setDistance(edge.getWeight() + distance));
        }
        
        System.out.println(graph);
    }
}
