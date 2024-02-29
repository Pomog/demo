package algorithms.greedy;

import lombok.Data;

@Data
public class HuffmanNode implements Comparable<HuffmanNode>{
    int freq;
    char data;
    HuffmanNode left, right;
    
    @Override
    public int compareTo(HuffmanNode huffmanNode) {
        return freq - huffmanNode.freq;
    }
    
    @Override
    public String toString() {
        return toStringHelper(this, "", "");
    }
    
    private String toStringHelper(HuffmanNode node, String prefix, String childrenPrefix) {
        if (node == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(node.data != '\0' ? node.data + "(" + node.freq + ")" : "-");
        sb.append("\n");
        
        // Append the left child with the appropriate prefixes
        sb.append(toStringHelper(node.getRight(), childrenPrefix + "├── ", childrenPrefix + "│   "));
        
        // Append the right child with the appropriate prefixes
        sb.append(toStringHelper(node.getLeft(), childrenPrefix + "└── ", childrenPrefix + "    "));
        
        return sb.toString();
    }

}
