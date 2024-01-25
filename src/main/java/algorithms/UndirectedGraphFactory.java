package algorithms;

import java.util.List;

public class UndirectedGraphFactory {

    public List<Vertex<Integer>> getGraph () {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        // adjacency list of the tree. it is not a really List
        v0.setNeighbors(List.of(v1, v5, v6));
        v1.setNeighbors(List.of(v0, v3, v4, v5));
        v2.setNeighbors(List.of(v4));
        v3.setNeighbors(List.of(v1));
        v4.setNeighbors(List.of(v1, v2, v6));
        v5.setNeighbors(List.of(v1, v0));
        v6.setNeighbors(List.of(v4, v0));


        // adjacency List of the tree
        List<Vertex<Integer>> adjacencyList = List.of(v0, v1, v2, v3, v4, v5, v6);

        return adjacencyList;
    }
}
