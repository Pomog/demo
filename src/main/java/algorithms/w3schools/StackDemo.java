package algorithms.w3schools;

public class StackDemo {
    public static void main(String[] args) {
        // Stack Implementation using Arrays
        StackArr myStackArr = new StackArr(10);
        
        myStackArr.push('A');
        myStackArr.push('B');
        myStackArr.push('C');
        
        // Print initial stack
        System.out.print("Stack: ");
        myStackArr.printStack();
        
        System.out.println("Pop: " + myStackArr.pop());
        System.out.println("Peek: " + myStackArr.peek());
        System.out.println("isEmpty: " + myStackArr.isEmpty());
        System.out.println("Size: " + myStackArr.size());
        
        // Stack Implementation using Linked Lists
        StackLL myStackLL = new StackLL();
        
        myStackLL.push('A');
        myStackLL.push('B');
        myStackLL.push('C');
        
        System.out.println("Pop: " + myStackLL.pop());
        System.out.println("Peek: " + myStackLL.peek());
        System.out.println("isEmpty: " + myStackLL.isEmpty());
        System.out.println("Size: " + myStackLL.size());
    }
}


// Stack Implementation using Arrays

class StackArr {
    char[] stackArr;
    int top;
    int capacity;
    
    public StackArr(int capacity) {
        this.capacity = capacity;
        this.stackArr = new char[capacity];
        this.top = -1;
    }
    
    public void push(char element) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        stackArr[++top] = element;
    }
    
    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }
        return stackArr[top--];
    }
    
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }
        return stackArr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }
}

// Stack Implementation using Linked Lists
class NodeStack {
    char value;
    NodeStack next;
    
    NodeStack(char value) {
        this.value = value;
        this.next = null;
    }
}

class StackLL {
    private NodeStack head;
    private int size;
    
    public StackLL() {
        this.head = null;
        this.size = 0;
    }
    
    public void push(char value) {
        NodeStack newNode = new NodeStack(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }
    
    public char pop() {
        if (isEmpty()) {
            return ' ';
        }
        char popped = head.value;
        head = head.next;
        size--;
        return popped;
    }
    
    public char peek() {
        if (isEmpty()) {
            return ' ';
        }
        return head.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}

