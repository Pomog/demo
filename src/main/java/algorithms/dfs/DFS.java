package algorithms.dfs;

import algorithms.Vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DFS<T> {
    private final Vertex<T> startVertex;

    public DFS(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(current.getNeighbors());
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public void traverseRecursively(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().forEach(neighbor -> {
            if (!neighbor.isVisited()){
                traverseRecursively(neighbor);
            }
        });
    }

    public void traverseRecursivelyStream(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(this::traverseRecursivelyStream);
    }
}
