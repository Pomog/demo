package algorithms.w3schools;

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArray = {64, 34, 25, 12, 22, 11, 90, 5};
        
        for (int insertIndex = 1; insertIndex < myArray.length; insertIndex++) {
            int currentValue = myArray[insertIndex];
            int j = insertIndex - 1;
            
            while (j >= 0 && myArray[j] > currentValue) {
                myArray[j + 1] = myArray[j];
                insertIndex = j;
                j--;
            }
            myArray[insertIndex] = currentValue;
        }
        
        System.out.print("Sorted array: ");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
    }
}

