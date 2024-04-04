package algorithms.dfs;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(exclude = {"left", "right"})
public class NodeW3 {
    @NonNull
    private final String data;
    private NodeW3 left;
    private NodeW3 right;
    
    public static void preOrderTraversal(NodeW3 node) {
        if (node == null) {
            return;
        }
        System.out.print(node + ", ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }
}
