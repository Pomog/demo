package algorithms.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to check if a given tree is a subtree of another tree.
 */

public class BinarySubtree {
    public static void main(String[] args) {
        NodeFactory nodeFactory = new NodeFactory();
        
        Node binaryTreeRoot = nodeFactory.createBinaryTree();
        Node binarySubTreeRoot = nodeFactory.createBinarySubTree();
        
        System.out.println(checkSubtree(binaryTreeRoot, binarySubTreeRoot));
        
    }
    
    /**
     * Checks if a given tree is a subtree of another tree.
     *
     * @param treeRoot    The root of the main tree.
     * @param subtreeRoot The root of the subtree.
     * @return True if the subtree is found in the main tree, false otherwise.
     */
    private static boolean checkSubtree(Node treeRoot, Node subtreeRoot) {
        if (subtreeRoot == null || treeRoot == null) {
            return false;
        }
        
        List<Integer> first = new ArrayList<>();
        inorder(treeRoot, first);
        
        List<Integer> second = new ArrayList<>();
        inorder(subtreeRoot, second);
        
        if (!listToString(first).contains(listToString(second))) {
            return false;
        }
        
        first.clear();
        second.clear();
        
        preorder(treeRoot, first);
        preorder(subtreeRoot, second);
        
        return listToString(first).contains(listToString(second));
    }
    
    /**
     * Performs inorder traversal of the tree and populates the list with node values.
     *
     * @param node The current node being processed.
     * @param list The list to store the node values.
     */
    private static void inorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }
    
    /**
     * Performs preorder traversal of the tree and populates the list with node values.
     *
     * @param node The current node being processed.
     * @param list The list to store the node values.
     */
    private static void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preorder(node.left, list);
        preorder(node.right, list);
    }
    
    /**
     * Converts a list of integers to a string.
     *
     * @param list The list of integers.
     * @return A string representation of the list.
     */
    private static String listToString(List<Integer> list) {
        return list.toString().replace("[", "").replace("]", "").replace(",", "");
    }
}
