package algorithms.w3schools;

import algorithms.tree.NodeInt;

public class SearchInBSTdemo {
    public static void main(String[] args) {
        var binarySearch = new BinarySearchTree();
        binarySearch.CreateBinarySearchTree();
        
        var foundNode = binarySearch.search(binarySearch.root, 8);
        System.out.printf("\n foundNode: %s\n", foundNode);
        
        System.out.println("BST before insertion");
        NodeInt.inOrderTraversal(binarySearch.root);
        
        binarySearch.insert(binarySearch.root, 10);
        
        System.out.println("\nBST after insertion of *10*");
        NodeInt.inOrderTraversal(binarySearch.root);
    }
}
