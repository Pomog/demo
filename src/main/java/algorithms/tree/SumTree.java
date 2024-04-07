package algorithms.tree;

public class SumTree {
    public static void main(String[] args) {
        NodeInt root = new NodeInt(8);
        root.setLeft(new NodeInt(7));
        root.setRight(new NodeInt(-4));
        root.getLeft().setLeft(new NodeInt(3));
        root.getLeft().setRight(new NodeInt(-6));
        root.getRight().setLeft(new NodeInt(7));
        root.getRight().setRight(new NodeInt(9));
        
        System.out.println("Initial Tree, preOrder");
        NodeInt.preOrderTraversal(root);
        System.out.println("end");
        
        root.convertIntoSumTree(root);
        
        System.out.println("Sum Tree, preOrder");
        NodeInt.preOrderTraversal(root);
        System.out.println("end");
    }
}
