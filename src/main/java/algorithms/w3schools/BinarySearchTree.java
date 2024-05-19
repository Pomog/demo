package algorithms.w3schools;

import algorithms.tree.NodeInt;

public class BinarySearchTree {
    NodeInt root;
    
    //    Delete a Node in a BST
    /*
        1. If the node is a leaf node, remove it by removing the link to it.
        2. If the node only has one child node, connect the parent node of the node you want to remove to that child node.
        3. If the node has both right and left child nodes:
            Find the node's in-order successor, change values with that node, then delete it.
     */
    
    /**
     *
     * @param node  the root node of the BST
     * @param data  the value of the node which should be deleted
     * @return Null if there was no deletion or deleted node
     */
    public NodeInt delete(NodeInt node, int data) {
        if (node == null) {
            return null;
        }
        
        if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(delete(node.getRight(), data));
        } else {
            // Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            
            // Node with two children: Get the inorder successor
            node.setData(minValueNode(node.getRight()).getData());
            node.setRight(delete(node.getRight(), node.getData()));
        }
        return node;
    }
    
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
     * @param node   the root node of the BST to be searched
     * @param target the value to search for
     * @return the node containing the target value if found; otherwise, null
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
     * @param node the root node of the BST to be inserted
     * @param data the value to insert
     * @return the inserted node or node with equal data, if data exist
     */
    public NodeInt insert(NodeInt node, int data) {
        System.out.println(node);
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
    
    /**
     * Find the MIN Node of the binary search tree (BST).
     *
     * @return the most lest node of the binary search tree (BST).
     */
    
    public NodeInt minValueNode(NodeInt root) {
        NodeInt current = root;
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
