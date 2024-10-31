package algorithms.named.kosaraju;

import algorithms.named.base.Vertex;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@RequiredArgsConstructor
public class KosarajuAlgorithm<T> {
    @NonNull
    private final Graph<T> graph;
    
    public List<List<Vertex<T>>> findStronglyConnectedComponents() {
        Stack<Vertex<T>> finishStack = new Stack<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getVertices()) {
            if (!visited.contains(vertex)) {
                dfsFirstPass(vertex, visited, finishStack);
            }
        }
        
        Graph<T> transposedGraph = graph.getTranspose();
        
        visited.clear();
        
        List<List<Vertex<T>>> stronglyConnectedComponents = new ArrayList<>();
        
        while (!finishStack.isEmpty()) {
            Vertex<T> vertex = finishStack.pop();
            if (!visited.contains(vertex)) {
                List<Vertex<T>> component = new ArrayList<>();
                dfsSecondPass(transposedGraph, vertex, visited, component);
                stronglyConnectedComponents.add(component);
            }
        }
        
        return stronglyConnectedComponents;
    }
    
    public void printStronglyConnectedComponents() {
        List<List<Vertex<T>>> scc = findStronglyConnectedComponents();
        
        System.out.println("Strongly Connected Components:");
        for (int i = 0; i < scc.size(); i++) {
            System.out.print("Component " + (i + 1) + ": ");
            List<Vertex<T>> component = scc.get(i);
            
            component.forEach(vertex -> System.out.print(vertex + " "));
            System.out.println();
        }
    }
    
    private void dfsFirstPass(Vertex<T> vertex, Set<Vertex<T>> visited, Stack<Vertex<T>> finishStack) {
        visited.add(vertex);
        for (Vertex<T> neighbor : graph.getAdjList().get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsFirstPass(neighbor, visited, finishStack);
            }
        }
        finishStack.push(vertex);
    }
    
    private void dfsSecondPass(Graph<T> transposedGraph, Vertex<T> vertex, Set<Vertex<T>> visited, List<Vertex<T>> component) {
        visited.add(vertex);
        component.add(vertex);
        for (Vertex<T> neighbor : transposedGraph.getAdjList().get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsSecondPass(transposedGraph, neighbor, visited, component);
            }
        }
    }
}