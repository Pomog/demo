package algorithms.w3schools;

public class HashTables {

    static final String[] myHashSet = {null, "Jones", null, "Lisa", null, "Bob", null, "Siri", "Pete", null};
    public static void main(String[] args) {
        String value = "Bob";
        System.out.println("'" + value + "' has hash code: " + hashFunction(value));

        System.out.println("'Pete' is in the Hash Set: " + contains("Pete"));
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
