package algorithms.named.base;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Edge<T> {
    private final Vertex<T> from;
    private final Vertex<T> to;
    private int capacity;
    private int flow = 0;
    
    public int residualCapacity() {
        return capacity - flow;
    }
    
    public void augmentFlow(int amount) {
        this.flow += amount;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        
        Edge<?> edge = (Edge<?>) o;
        
        if (!getFrom().equals(edge.getFrom())) return false;
        return getTo().equals(edge.getTo());
    }
    
    @Override
    public int hashCode() {
        int result = getFrom().hashCode();
        result = 31 * result + getTo().hashCode();
        return result;
    }
}
