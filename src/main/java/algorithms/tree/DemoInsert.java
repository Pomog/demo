package algorithms.tree;

import algorithms.dfs.BinarySearchTree;

public class DemoInsert {
    public static void main(String[] args) {
//     var rootNode = NodeInt.createBinaryTreeInt();
       var rootNode = new NodeInt(13);
       var tree = new BinarySearchTree(rootNode);
       
       NodeInt.inOrderTraversal(tree.getRoot());
       System.out.println();
       
       tree.insert(15);
       tree.insert(7);
       
       NodeInt.inOrderTraversal(tree.getRoot());
       System.out.println();
       
       var searchNode = tree.search(13);
       System.out.println(searchNode.toString());
       System.out.printf("\nThe left child of the found node is %s", searchNode.getLeft().toString());
       System.out.printf("\nThe right child of the found node is %s", searchNode.getRight().toString());
       

       
    }
    

}
