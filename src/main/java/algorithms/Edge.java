package algorithms;

import algorithms.Vertex;
import lombok.Data;

@Data
public class Edge<T> {
    private final Vertex<T> from;
    private final Vertex<T> to;
    private final int weight;
    
    public Edge(Vertex<T> from, Vertex<T> to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}