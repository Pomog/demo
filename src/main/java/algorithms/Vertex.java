package algorithms;


import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString(exclude = {"neighbors", "parents", "children", "visited"})
public class Vertex<T> {
    private final T data;
    // Indicates whether the vertex has been visited during graph traversal.
    private boolean visited;
    // Represents the vertices connected to this vertex through edges. For undirected graphs.
    private List<Vertex<T>> neighbors = new LinkedList<>();
    private List<Vertex<T>> parents = new LinkedList<>();
    // Represents the child vertices in the graph hierarchy.
    private List<Vertex<T>> children = new LinkedList<>();
    // Represent the distance from the source
    private Integer distance;

    public Vertex(T data) {
        this.data = data;
    }

    /**
     * Overrides the equals method to compare vertices based on their data.
     *
     * @param o The object to compare with this vertex.
     * @return True if the vertices have the same data, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> vertex = (Vertex<?>) o;

        return data.equals(vertex.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}