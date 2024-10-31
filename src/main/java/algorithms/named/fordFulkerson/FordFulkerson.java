package algorithms.named.fordFulkerson;

import algorithms.named.base.Edge;
import algorithms.named.base.Vertex;

import java.util.*;

public class FordFulkerson<T> {
    private final Map<Vertex<T>, List<Edge<T>>> graph;
    
    public FordFulkerson(Map<Vertex<T>, List<Edge<T>>> graph) {
        this.graph = graph;
    }
    
    public int findMaxFlow(Vertex<T> source, Vertex<T> sink) {
        int maxFlow = 0;
        
        List<Edge<T>> path;
        while ((path = findAugmentingPath(source, sink)) != null) {
            int pathFlow = Integer.MAX_VALUE;
            
            for (Edge<T> edge : path) {
                pathFlow = Math.min(pathFlow, edge.residualCapacity());
            }
            
            for (Edge<T> edge : path) {
                edge.augmentFlow(pathFlow);
                }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }
    
    private List<Edge<T>> findAugmentingPath(Vertex<T> source, Vertex<T> sink) {
        Map<Vertex<T>, Edge<T>> parentMap = new HashMap<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(source);
        
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            
            for (Edge<T> edge : graph.get(vertex)) {
                if (!parentMap.containsKey(edge.getTo()) && edge.residualCapacity() > 0) {
                    parentMap.put(edge.getTo(), edge);
                    queue.add(edge.getTo());
                    
                    if (edge.getTo().equals(sink)) {
                        return reconstructPath(parentMap, source, sink);
                    }
                }
            }
        }
        return null;
    }
    
    private List<Edge<T>> reconstructPath(Map<Vertex<T>, Edge<T>> parentMap, Vertex<T> source, Vertex<T> sink) {
        List<Edge<T>> path = new ArrayList<>();
        Vertex<T> current = sink;
        
        while (!current.equals(source)) {
            Edge<T> edge = parentMap.get(current);
            path.add(edge);
            current = edge.getFrom();
        }
        
        Collections.reverse(path);
        return path;
    }
    
    
    
}
