package algorithms;

import lombok.Getter;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph<T> {
    @Getter
    private final List<Edge<T>> edges = new LinkedList<>();
    
    public List<Vertex<T>> vertices = new LinkedList<>();
    
    // Add vertices and edges
    public void addEdge(Vertex<T> from, Vertex<T> to, int weight) {
        Edge<T> edge = new Edge<>(from, to, weight);
        edges.add(edge);
        from.getNeighbors().add(to); // For traversal
    }
    
    public Vertex<T> getUnvisitedVertexWithSmallestDistance() {
        return vertices.stream()
                .filter(v -> !v.isVisited())
                .min(Comparator.comparingInt(Vertex::getDistance))
                .orElse(null);
    }
    
    public List<Edge<T>> getNotVisitedEdgesOfVertex (Vertex<T> v){
        return edges.stream()
                .filter(e -> e.getFrom() == v)
                .filter(e -> !e.getTo().isVisited())
                .collect(Collectors.toList());
    }
    
    public Boolean notVisitedVerticesPresent(){
        return !vertices.stream()
                .allMatch(Vertex::isVisited);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Print all vertices
        sb.append("Vertices:\n");
        for (Vertex<T> vertex : vertices) {
            sb.append(vertex.getData())
                    .append(" distance ")
                    .append(vertex.getDistance())
                    .append("\n");
        }
        
        // Print all edges with weights
        sb.append("\nEdges:\n");
        for (Edge<T> edge : edges) {
            sb.append(edge.getFrom().getData()).append(" -> ")
                    .append(edge.getTo().getData())
                    .append(" [Weight: ").append(edge.getWeight()).append("]\n");
        }
        
        return sb.toString();
    }
}