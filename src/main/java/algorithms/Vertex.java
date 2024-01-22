package algorithms;


import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString(exclude = {"neighbors"})
public class Vertex<T> {
    private final T data;
    public Vertex(T data) {
        this.data = data;
    }
    private boolean visited;
    private List<Vertex<T>> neighbors = new LinkedList<>();
}