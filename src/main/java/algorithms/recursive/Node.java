package algorithms.recursive;

/**
 * Represents a node in a binary tree.
 */
public class Node {
    int data;
    Node left = null;
    Node right = null;
    
    public Node(int data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Node{" + data + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Node node = (Node) o;
        
        return data == node.data;
    }
    
    @Override
    public int hashCode() {
        return data;
    }
}
