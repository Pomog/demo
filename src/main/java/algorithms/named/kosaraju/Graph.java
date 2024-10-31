package algorithms.named.kosaraju;

import algorithms.named.base.Edge;
import algorithms.named.base.Vertex;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Data
public class Graph<T> {
    private final Logger logger;
    private final List<Vertex<T>> vertices;
    private final List<Edge<T>> edges;
    private final Map<Vertex<T>, List<Vertex<T>>> adjList;
    
    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.adjList = new HashMap<>();
        
        this.logger = Logger.getLogger(this.getClass().getSimpleName());
    }
    
    public void addVertex(Vertex<T> vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        } else {
            logger.info("Vertex: " + vertex + " is already added");
        }
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }
    
    public void addEdge(Vertex<T> from, Vertex<T> to) {
        addVertex(from);
        addVertex(to);
        
        Edge<T> edge = new Edge<>(from, to);
        if (!edges.contains(edge)) {
            edges.add(edge);
            adjList.get(from).add(to);
        } else {
            logger.info("Edge: " + from + " -> " + to + " is already added.");
        }
    }
    
    public Graph<T> getTranspose() {
        Graph<T> transpose = new Graph<>();
        for (Vertex<T> vertex : vertices) {
            transpose.addVertex(vertex);
        }
        for (Edge<T> edge : edges) {
            transpose.addEdge(edge.getTo(), edge.getFrom());
        }
        logger.info("Transpose graph created.");
        return transpose;
    }
}