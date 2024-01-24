package algorithms;


import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString(exclude = {"neighbors", "parents", "children", "visited"})
public class Vertex<T> {
    private final T data;

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

    public Vertex(T data) {
        this.data = data;
    }
    private boolean visited;
    private List<Vertex<T>> neighbors = new LinkedList<>();
    private List<Vertex<T>> parents = new LinkedList<>();
    private List<Vertex<T>> children = new LinkedList<>();
}