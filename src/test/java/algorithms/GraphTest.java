package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    private Graph<String> graph;
    private Vertex<String> vertexA;
    private Vertex<String> vertexB;
    
    @BeforeEach
    public void setup() {
        graph = new Graph<>();
        vertexA = new Vertex<>("A");
        vertexB = new Vertex<>("B");
        
        graph.vertices.add(vertexA);
        graph.vertices.add(vertexB);
    }
    
    @Test
    public void testAllVerticesVisited_WhenAllVisited_ShouldReturnTrue() {
        // Mark all vertices as visited
        vertexA.setVisited(true);
        vertexB.setVisited(true);
        
        // Test if all vertices are visited
        assertFalse(graph.notVisitedVerticesPresent(), "Expected all vertices to be visited");
    }
    
    @Test
    public void testAllVerticesVisited_WhenOneNotVisited_ShouldReturnFalse() {
        // Mark only one vertex as visited
        vertexA.setVisited(true);
        vertexB.setVisited(false);
        
        // Test if all vertices are visited
        assertTrue(graph.notVisitedVerticesPresent(), "Expected not all vertices to be visited");
    }
}