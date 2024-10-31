package algorithms.named.base;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Vertex<T> {
    private final int id;
    @NonNull
    private final T data;
    private boolean visited;
    
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        
        Vertex<?> vertex = (Vertex<?>) o;
        
        if (getId() != vertex.getId()) return false;
        return getData().equals(vertex.getData());
    }
    
    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getData().hashCode();
        return result;
    }
}
