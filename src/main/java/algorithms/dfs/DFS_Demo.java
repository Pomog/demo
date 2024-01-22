package algorithms.dfs;

import algorithms.Vertex;
import algorithms.bfs.BFS;

import java.util.List;

public class DFS_Demo {
    public static void main(String[] args) {

        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        Vertex<Integer> v7 = new Vertex<>(7);
        Vertex<Integer> v8 = new Vertex<>(8);

        // adjacency list of the tree
        v0.setNeighbors(List.of(v1, v5, v6));
        v1.setNeighbors(List.of(v3, v4, v5));
        v4.setNeighbors(List.of(v2, v6));
        v6.setNeighbors(List.of(v0, v8));
        v2.setNeighbors(List.of(v7));
        v7.setNeighbors(List.of(v6));

//        System.out.println("traverseRecursivelyStream");
//        new DFS<>(v0).traverseRecursivelyStream(v0);

//        System.out.println("traverse");
//        new DFS<>(v0).traverse();

//        System.out.println("Leaves");
//        new DFS<>(v0).findLeaves();

        System.out.println("TreeHeight");
        System.out.println(new DFS<>(v0).height(v0));
    }
}
