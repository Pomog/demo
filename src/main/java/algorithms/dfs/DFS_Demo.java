package algorithms.dfs;

import algorithms.UndirectedGraphFactory;
import algorithms.Vertex;
import algorithms.bfs.BFS;

import java.util.List;

public class DFS_Demo {
    public static void main(String[] args) {

        // adjacency List of the tree
        List<Vertex<Integer>> adjacencyList = new UndirectedGraphFactory().getGraph();

        System.out.println("traverseRecursivelyStream");
        new DFS<>(adjacencyList.get(0)).traverseRecursivelyStream(adjacencyList.get(0));


    }
}
