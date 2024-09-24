public class StackSizeTest {
    private static int depth = 0;

    public static void main(String[] args) {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.out.println("Maximum recursion depth: " + depth);
        }
    }

    public static void recursiveCall() {
        depth++;
        recursiveCall();
    }
}