package algorithms.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        int[] inOrder = {1, 5, 7, 6, 9, 14, 12};
        int[] levelOrder = {9, 5, 12, 1, 6, 14, 7};
        
        NodeInt root = construct(inOrder, levelOrder);
        NodeInt.inOrderTraversal(root);
    }
    
    private static NodeInt construct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < levelOrder.length; i++) {
            map.put(levelOrder[i], i);
        }
        
        return construct(inOrder, 0, inOrder.length - 1, map);
    }
    
    private static NodeInt construct(int[] inOrder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (map.get(inOrder[i]) < map.get(inOrder[index])) {
                index = i;
            }
        }
        NodeInt root = new NodeInt(inOrder[index]);
        
        root.setLeft(construct(inOrder, start, index - 1, map));
        root.setRight(construct(inOrder, index + 1, end, map));
        
        return root;
    }
}
