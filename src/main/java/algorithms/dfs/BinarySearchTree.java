package algorithms.dfs;

import algorithms.tree.NodeInt;
import lombok.Data;

@Data
public class BinarySearchTree {
    NodeInt root;
    
    public BinarySearchTree(NodeInt root) {
        this.root = root;
    }
    
    public void insert (int value){
        this.root = insertInBST(this.root, value);
    }
    
    
    private NodeInt insertInBST (NodeInt node, int value){
        if (node == null){
            return new NodeInt(value);
        }
        
        if (value < node.getData()){
            node.setLeft(insertInBST(node.getLeft(), value));
        } else if (value > node.getData()) {
            node.setRight(insertInBST(node.getRight(), value));
        }
        return node;
        
    }
    
    public NodeInt search (int value){
        return searchInBST(this.root, value);
    }
    
    
    private NodeInt searchInBST (NodeInt node, int value){
        if (node == null || node.getData() == value){
            return node;
        }
        
        if (value < node.getData()){
            return (searchInBST(node.getLeft(), value));
        } else if (value > node.getData()) {
            return (searchInBST(node.getRight(), value));
        }
        return node;
    }
    
    // TODO Delete Operation
    public void delete(int value){
        deleteFromBST(this.root, value);
    }
    
    private NodeInt deleteFromBST(NodeInt node, int value) {
        if( node == null) return null;
        
        if (value < node.getData()){
            node.setLeft(deleteFromBST(node.getLeft(), value));
        } else if (value > node.getData()) {
            node.setRight(deleteFromBST(node.getRight(), value));
        } else {

            if (node.getLeft() == null){
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            
            node.setData(minValue(node.getRight()));
            node.setRight(deleteFromBST(node.getRight(), node.getData()));
        }
        return node;
    }
    
    private int minValue (NodeInt right){
        int min = right.getData();
        
        //get left most value in the right subtree
        while (right.getLeft() != null){
            min = right.getLeft().getData();
            right = right.getLeft();
        }
        
        return min;
    }
    
}
