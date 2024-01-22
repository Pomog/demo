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

    public void findLeaves() {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);

                boolean isLeaf = current.getNeighbors().stream()
                        .allMatch(Vertex::isVisited);

                if (isLeaf) {
                    System.out.println(current);
                }
                current.getNeighbors().forEach(stack::push);
            }
        }
    }

    public Integer height(Vertex<T> vertex) {
        if (vertex == null || vertex.isVisited()) {
            return -1;
        }

        vertex.setVisited(true);

        int maxHeight = -1;

        for (Vertex<T> neighbor : vertex.getNeighbors()) {
            if (!neighbor.isVisited()) {
                int childHeight = height(neighbor);
                maxHeight = Math.max(maxHeight, childHeight);
                System.out.println(neighbor);
                System.out.println(maxHeight);
            }
        }

        vertex.setVisited(false);

        return 1 + maxHeight;
    }

}
