package algorithms.w3schools;

import algorithms.dfs.NodeW3;

public class InvertDemo {
    public static void main(String[] args) {
        var tree = new InvertBinaryTree();
        
        tree.createTree();
        System.out.println("Tree Root: " + tree.root.getData());
        
        System.out.println("In-order Traversal");
        NodeW3.inOrderTraversal(tree.root);
        System.out.println();
        
        tree.invertBinaryTree(tree.root);
        
        System.out.println("In-order Traversal. After inversion");
        NodeW3.inOrderTraversal(tree.root);
    }
}
