package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanCode {
    
    static HuffmanNode root;
    static Map<Character, String> charactermStringMap = new HashMap<>();
    public static void main(String[] args) {
        String str = "ABBCCCCGGGGDEAAAEDBBBDFAGG";
        
        String code = encode(str);
        
        System.out.printf("Final Coded String = %s\n", code);
    }
    
    private static String encode(String str) {
        Map<Character, Integer> f = new HashMap<>();
        
        // Calculate frequency of characters
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!f.containsKey(c)){
                f.put(c, 0);
            }
            f.put(c, f.get(c)+1);
        }
        
        HuffmanNode root2 = generateTree(f);
        setBinaryCode(root2, new StringBuilder());
        System.out.printf("Binary Codes: %s\n", charactermStringMap);
        
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <str.length(); i++){
            char c = str.charAt(i);
            s.append(charactermStringMap.get(c));
        }
        
        return  s.toString();
    }
    
    private static void setBinaryCode(HuffmanNode node, StringBuilder stringBuilder) {
        
        if (node != null) {
            
            if (node.getLeft() == null && node.getRight() == null) {
                charactermStringMap.put(node.getData(), stringBuilder.toString());
            } else {
                stringBuilder.append('0');
                setBinaryCode(node.getLeft(), stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                
                stringBuilder.append('1');
                setBinaryCode(node.getRight(), stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
    
    private static HuffmanNode generateTree(Map<Character, Integer> f) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        Set<Character> keySet = f.keySet();
        
        System.out.println(f);
        
        for (Character character : keySet){
            HuffmanNode node = new HuffmanNode();
            node.setData(character);
            node.setFreq(f.get(character));
            node.setLeft(null);
            node.setRight(null);
            
            System.out.println(node);
            
            priorityQueue.offer(node);
        }
        while (priorityQueue.size() > 1) {
            HuffmanNode first = priorityQueue.peek();
            priorityQueue.poll();
            
            HuffmanNode second = priorityQueue.peek();
            priorityQueue.poll();
            
            HuffmanNode mergeNode = new HuffmanNode();
            mergeNode.setLeft(first);
            mergeNode.setRight(second);
            mergeNode.setFreq(first.getFreq() + second.getFreq());
            mergeNode.setData('-');
            root = mergeNode;
            
            priorityQueue.offer(mergeNode);
        }
        System.out.printf("Tree :\n %s", priorityQueue.peek());
        return priorityQueue.poll();
    }
}
