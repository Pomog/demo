package algorithms.dfs;

public class Traversal {
    public static void main(String[] args) {
        NodeW3 root = new NodeW3("R");
        NodeW3 nodeA = new NodeW3("A");
        NodeW3 nodeB = new NodeW3("B");
        NodeW3 nodeC = new NodeW3("C");
        NodeW3 nodeD = new NodeW3("D");
        NodeW3 nodeE = new NodeW3("E");
        NodeW3 nodeF = new NodeW3("F");
        NodeW3 nodeG = new NodeW3("G");
        
        root.setLeft(nodeA);
        root.setRight(nodeB);
        
        nodeA.setLeft(nodeC);
        nodeA.setRight(nodeD);
        
        nodeB.setLeft(nodeE);
        nodeB.setRight(nodeF);
        
        nodeF.setLeft(nodeG);
        
        // Pre-order Traversal
        NodeW3.preOrderTraversal(root);
    }
}

