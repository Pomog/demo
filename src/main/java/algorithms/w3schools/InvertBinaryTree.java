package algorithms.w3schools;

import algorithms.dfs.NodeW3;

public class InvertBinaryTree {
    NodeW3 root;
    public void createTree(){
        // Make Tree
        this.root = new NodeW3("8");
        root.setLeft(new NodeW3("7"));
        root.setRight(new NodeW3("4"));
        root.getLeft().setLeft(new NodeW3("3"));
        root.getLeft().setRight(new NodeW3("6"));
        root.getRight().setLeft(new NodeW3("7"));
        root.getRight().setRight(new NodeW3("9"));
        root.getLeft().getLeft().setRight(new NodeW3("6"));
    }
    public void invertBinaryTree(NodeW3 node) {
        if(node == null) return;
        
        // swap
        NodeW3 temp =  node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        
        invertBinaryTree(node.getLeft());
        invertBinaryTree(node.getRight());
    }
}
