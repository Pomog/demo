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
}

