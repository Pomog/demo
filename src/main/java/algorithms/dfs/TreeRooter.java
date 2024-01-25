package algorithms.dfs;

import algorithms.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TreeRooter is a class that performs a tree-rooting algorithm on an undirected graph represented
 * by vertices. It uses breadth-first search (BFS) to traverse the graph, identify paths,
 * and root the tree.
 *
 * After traversing each vertex connected with children vertices according to the root.
 *
 * @param <T> The type of data stored in each vertex.
 */
public class TreeRooter<T> {
    private final Integer rootIndex;
    private final List<Vertex<T>> undirectedGraph;
    private List<List<Vertex<T>>> paths = new ArrayList<>();

    public TreeRooter(Integer rootIndex, List<Vertex<T>> undirectedGraph) {
        this.rootIndex = rootIndex;
        this.undirectedGraph = undirectedGraph;
    }

    /**
     * Performs a tree-rooting algorithm on the undirected graph starting from the specified root index.
     * It uses depth-first search (BFS) to traverse the graph, identify paths, and root the tree.
     *
     * @return The root vertex of the resulting directed rooted tree.
     */
    public Vertex<T> getRoot(){
        Queue<Vertex<T>> queue = new LinkedList<>();
        Vertex<T> rootVertex = this.undirectedGraph.get(rootIndex);
        queue.add(rootVertex);
        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            if (!currentVertex.isVisited()) {
                currentVertex.setVisited(true);
                for (Vertex<T> neighborVertex : currentVertex.getNeighbors()){
                    // add path from currentVertex to neighborVertex and reverse
                    List<Vertex<T>> path = createPath(currentVertex, neighborVertex);
                    List<Vertex<T>> pathRev = createPath(neighborVertex, currentVertex);

                    /*
                        if  traversed paths not contains the new created path,
                        add it
                        add the neighborVertex to the queue
                        add neighborVertex to the currentVertex children
                     */
                    if (!paths.contains(path) || !paths.contains(pathRev) ){
                        this.paths.add(path);
                        this.paths.add(pathRev);
                        queue.add(neighborVertex);
                        currentVertex.getChildren().add(neighborVertex);
                        neighborVertex.getParents().add(currentVertex);
                    }
                }
            }
        }
        return undirectedGraph.get(rootIndex);
    }

    /**
     * Creates a path from {@code vertex1} to {@code vertex2}.
     *
     * @param vertex1 The starting vertex.
     * @param vertex2 The ending vertex.
     * @return A list representing the path from {@code vertex1} to {@code vertex2}.
     */
    private List<Vertex<T>> createPath(Vertex<T> vertex1, Vertex<T> vertex2) {
        List<Vertex<T>> path = new ArrayList<>();
        path.add(vertex1);
        path.add(vertex2);
        return path;
    }
}
