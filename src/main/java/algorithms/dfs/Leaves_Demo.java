package algorithms.dfs;

import algorithms.UndirectedGraphFactory;
import algorithms.Vertex;

import java.util.List;

public class Leaves_Demo {
    public static void main(String[] args) {

        // adjacency List of the tree
        List<Vertex<Integer>> adjacencyList = new UndirectedGraphFactory().getGraph();

        System.out.println("Leaves");
        new DFS<>(adjacencyList.get(0)).findLeaves();

    }
}
