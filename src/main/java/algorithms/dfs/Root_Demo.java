package algorithms.dfs;

import algorithms.UndirectedGraphFactory;
import algorithms.Vertex;

import java.util.List;

public class Root_Demo {
    public static void main(String[] args) {

        // adjacency List of the tree
        List<Vertex<Integer>> adjacencyList = new UndirectedGraphFactory().getGraph();


        // Create a TreeRooter instance
        TreeRooter<Integer> treeRooter = new TreeRooter<>(0, adjacencyList);

        // Print the root of the tree
        System.out.println("Root of the tree: " + treeRooter.GetRootNode());

        // Print all nodes
        System.out.println("All nodes in the tree:");
        for (Vertex<Integer> vertex : adjacencyList) {
            System.out.println("Node " + vertex.getData()
                    + ", Children: " + vertex.getChildren()
                    + ", Parents: " + vertex.getParents())
            ;
        }
    }
}