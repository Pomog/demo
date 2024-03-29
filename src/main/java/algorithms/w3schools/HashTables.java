package algorithms.w3schools;

import java.util.EnumMap;
import java.util.Map;

public class HashTables {

    static final String[] myHashSet = {null, "Jones", null, "Lisa", null, "Bob", null, "Siri", "Pete", null};
    public static void main(String[] args) {
        String value = "Bob";
        System.out.println("'" + value + "' has hash code: " + hashFunction(value));

        System.out.println("'Pete' is in the Hash Set: " + contains("Pete"));
        
        Map<MyEnum, String> myEnumHashMap = new EnumMap<>(MyEnum.class);
        myEnumHashMap.put(MyEnum.MONDAY, "First");
        myEnumHashMap.put(MyEnum.FRIDAY, "Fifth");
        
        System.out.println(myEnumHashMap + "\n size =" + myEnumHashMap.size() );
        
    }

    public static int hashFunction(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }
        return sum % 10;
    }

    public static boolean contains(String name) {
        int index = hashFunction(name);
        return myHashSet[index] != null && myHashSet[index].equals(name);
    }
}
