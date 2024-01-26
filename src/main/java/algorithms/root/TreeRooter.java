package algorithms.root;

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
 * After traversing each vertex connected with children and parent vertices according to the root.
 *
 * @param <T> The type of data stored in each vertex.
 */
public class TreeRooter<T> {
    private final Integer rootIndex;
    private final List<Vertex<T>> undirectedGraph;
    private final List<List<Vertex<T>>> paths = new ArrayList<>();

    /**
     * Constructs a TreeRooter with the specified root index and undirected graph.
     *
     * @param rootIndex      The index of the root vertex.
     * @param undirectedGraph The list of vertices representing the undirected graph.
     * @throws IllegalArgumentException if rootIndex is not within the valid range of indices.
     */
    public TreeRooter(Integer rootIndex, List<Vertex<T>> undirectedGraph) {
        if (rootIndex < 0 || rootIndex >= undirectedGraph.size()) {
            throw new IllegalArgumentException("Invalid rootIndex: " + rootIndex);
        }
        this.rootIndex = rootIndex;
        this.undirectedGraph = undirectedGraph;
    }

    /**
     * Performs a tree-rooting algorithm on the undirected, unsorted graph starting from the specified root index.
     * It uses breadth-first search (BFS) to traverse the graph,
     * identify paths, and adds founded children and parent {@link Vertex}
     * traversed paths are used to update corresponds vertices.
     *
     * @return The root {@link Vertex} of the resulting directed rooted tree.
     */
    public Vertex<T> getRoot(){
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(this.undirectedGraph.get(rootIndex));
        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            processVertex(currentVertex, queue);
        }
        return undirectedGraph.get(rootIndex);
    }

    /**
     * Process a single vertex in the tree-rooting algorithm.
     *
     * @param currentVertex The current vertex being processed.
     * @param queue The queue of vertices to be processed.
     */
    private void processVertex(Vertex<T> currentVertex, Queue<Vertex<T>> queue) {
        if (!currentVertex.isVisited()) {
            currentVertex.setVisited(true);
            for (Vertex<T> neighborVertex : currentVertex.getNeighbors()){
                processNeighbor(currentVertex, neighborVertex, queue);
            }
        }
    }

    /**
     * Process a neighbor vertex in the tree-rooting algorithm.
     *
     * @param neighborVertex The neighboring vertex.
     * @param currentVertex The current vertex being processed.
     * @param queue The queue of vertices to be processed.
     *
     * @todo To improve efficiency and clarity, it is better to avoid using both 'edge' and 'edgeReversed'.
     */
    private void processNeighbor(Vertex<T> currentVertex, Vertex<T> neighborVertex, Queue<Vertex<T>> queue) {
        // add path from currentVertex to neighborVertex and reverse
        List<Vertex<T>> edge = createEdge(currentVertex, neighborVertex);
        List<Vertex<T>> edgeReversed = createEdge(neighborVertex, currentVertex);

        if (!paths.contains(edge) || !paths.contains(edgeReversed) ){
            updateVerticesStructure(neighborVertex, edge, edgeReversed, queue, currentVertex);
        }
    }

    /**
     * Updates the graph structure by adding paths, updating the queue, children, and parents.
     *
     * @param neighborVertex The neighboring vertex.
     * @param edge The original path from currentVertex to neighborVertex.
     * @param edgeReversed The reversed path from neighborVertex to currentVertex.
     *                     it is created by {@link #processNeighbor(Vertex, Vertex, Queue)}
     * @param queue The queue of vertices to be processed.
     * @param currentVertex The current vertex being processed.
     */
    private void updateVerticesStructure(Vertex<T> neighborVertex, List<Vertex<T>> edge, List<Vertex<T>> edgeReversed, Queue<Vertex<T>> queue, Vertex<T> currentVertex) {
        this.paths.add(edge);
        this.paths.add(edgeReversed);
        queue.add(neighborVertex);
        currentVertex.getChildren().add(neighborVertex);
        neighborVertex.getParents().add(currentVertex);
    }

    /**
     * Creates an edge and reverse edge from {@code vertex1} to {@code vertex2}.
     *
     * @param vertex1 The starting vertex.
     * @param vertex2 The ending vertex.
     * @return A list representing the path from {@code vertex1} to {@code vertex2}.
     */
    private List<Vertex<T>> createEdge(Vertex<T> vertex1, Vertex<T> vertex2) {
        List<Vertex<T>> path = new ArrayList<>();
        path.add(vertex1);
        path.add(vertex2);
        return path;
    }
}
