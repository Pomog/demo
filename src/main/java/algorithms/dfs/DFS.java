package algorithms.dfs;

import algorithms.Vertex;

import java.util.Deque;
import java.util.LinkedList;

public class DFS<T> {
    private final Vertex<T> startVertex;

    public DFS(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
/*
  here Class Stack can be used but it is outdated, inherits form Vector,
and Deque interface can also be synchronized
Collections.synchronizedDeque()
 */
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
        if (vertex == null) {
            return -1;
        }

        vertex.setVisited(true);

        int maxHeight = -1;

        for (Vertex<T> neighbor : vertex.getNeighbors()) {
            if (!neighbor.isVisited()) {
                maxHeight = Math.max(maxHeight, height(neighbor));
            }
        }

        vertex.setVisited(false);

        return 1 + maxHeight;
    }

}
