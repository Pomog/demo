package algorithms.tree;

public class SumTree {
    public static void main(String[] args) {
        NodeInt root = NodeInt.createBinaryTreeInt();
        
        System.out.println("Initial Tree, preOrder");
        NodeInt.preOrderTraversal(root);
        System.out.println("end");
        
        root.convertIntoSumTree(root);
        
        System.out.println("Sum Tree, preOrder");
        NodeInt.preOrderTraversal(root);
        System.out.println("end");
    }
}
