package algorithms.w3schools;

import algorithms.tree.NodeInt;

import java.util.Optional;

public class BinarySearchTree {
    NodeInt root;
    
    public void CreateBinarySearchTree() {
        var root = new NodeInt(13);
        var node7 = new NodeInt(7);
        var node15 = new NodeInt(15);
        var node3 = new NodeInt(3);
        var node8 = new NodeInt(8);
        var node14 = new NodeInt(14);
        var node19 = new NodeInt(19);
        var node18 = new NodeInt(18);
        
        root.setLeft(node7);
        root.setRight(node15);
        
        node7.setLeft(node3);
        node7.setRight(node8);
        
        node15.setLeft(node14);
        node15.setRight(node19);
        
        node19.setLeft(node18);
        
        this.root = root;
    }
    
    /**
     * Searches for a node with the specified target value in the binary search tree (BST).
     *
     * @param node    the root node of the BST to be searched
     * @param target  the value to search for
     * @return        the node containing the target value if found; otherwise, null
     */
    public NodeInt search(NodeInt node, int target) {
        if (node == null) {
            return null;
        } else if (node.getData() == target) {
            return node;
        } else if (target < node.getData()) {
            return search(node.getLeft(), target);
        } else {
            return search(node.getRight(), target);
        }
    }
    
    /**
     * Insert a node to the binary search tree (BST).
     *
     * @param   node  the root node of the BST to be searched
     * @param   data  the value to insert
     * @return  the inserted node or node with equal data
     */
    public NodeInt insert(NodeInt node, int data) {
        if (node == null) {
            return new NodeInt(data);
        } else {
            if (data < node.getData()) {
                node.setLeft(insert(node.getLeft(), data));
            } else if (data > node.getData()) {
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }
}
