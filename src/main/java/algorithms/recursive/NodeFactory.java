package algorithms.recursive;

/**
 * Factory class to create nodes for a binary tree.
 */
public class NodeFactory {
    /**
     * Creates a new node with the given data.
     *
     * @param data The data for the node.
     * @return A new node with the given data.
     */
    public Node create(int data) {
        return new Node(data);
    }
    
    /**
     * Creates a binary tree.
     *
     * @return The root node of the binary tree.
     */
    public Node createBinaryTree (){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        return root;
    }
    
    /**
     * Creates a binary subtree.
     *
     * @return The root node of the binary subtree.
     */
    public Node createBinarySubTree (){
        Node root = new Node(2);
        root.left = new Node(4);
        root.right = new Node(5);
        
        return root;
    }
}
