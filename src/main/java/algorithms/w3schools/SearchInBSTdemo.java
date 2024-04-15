package algorithms.w3schools;

import algorithms.tree.NodeInt;

public class SearchInBSTdemo {
    public static void main(String[] args) {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.CreateBinarySearchTree();
        System.out.printf("\n ROOT NODE: %s\n", binarySearchTree.root);
        
        var foundNode = binarySearchTree.search(binarySearchTree.root, 8);
        System.out.printf("\n foundNode: %s\n", foundNode);
        
        System.out.println("BST before insertion");
        NodeInt.inOrderTraversal(binarySearchTree.root);
        System.out.println();
        
        binarySearchTree.insert(binarySearchTree.root, 10);
        
        System.out.println("\nBST after insertion of *10*");
        NodeInt.inOrderTraversal(binarySearchTree.root);
        
        System.out.printf("\nThe MIN (most left) node of the BST: %s\n", binarySearchTree.minValueNode().toString());
    }
}
