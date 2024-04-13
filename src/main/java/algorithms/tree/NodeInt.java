package algorithms.tree;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"left", "right"})
public class NodeInt {
    private int data;
    private NodeInt left;
    private NodeInt right;
    
    public NodeInt(int data) {
        this.data = data;
    }
    
    public static void preOrderTraversal(NodeInt node) {
        if (node == null) {
            return;
        }
        System.out.print(node + ", ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }
    
    public static void inOrderTraversal(NodeInt node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + ", ");
        inOrderTraversal(node.getRight());
    }
    
    public int convertIntoSumTree(NodeInt node) {
        if (node == null){
            return 0;
        }
        
        int oldValue = node.getData();
        
        int leftTreeSum = convertIntoSumTree(node.getLeft());
        int rightTreeSum = convertIntoSumTree(node.getRight());
        
        node.setData(leftTreeSum + rightTreeSum);
        
        return node.getData() + oldValue;
    }
    
    public static NodeInt createBinaryTreeInt() {
        NodeInt root = new NodeInt(8);
        root.setLeft(new NodeInt(7));
        root.setRight(new NodeInt(-4));
        root.getLeft().setLeft(new NodeInt(3));
        root.getLeft().setRight(new NodeInt(-6));
        root.getRight().setLeft(new NodeInt(7));
        root.getRight().setRight(new NodeInt(9));
        
        return root;
    }
}

