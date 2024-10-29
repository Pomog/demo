package collections;

import java.util.Arrays;
import java.util.logging.Logger;

public class CollectionsTrainings {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        System.out.println(intArray.getClass().getSimpleName());
        
        new CollectionsTrainings().run();
        
        int[][] twoD = new int[2][2];
        Arrays.stream(twoD).forEach(arr  -> Arrays.stream(arr).forEach(System.out::println));
        
        long[] longs = new long[1];
        longs[0] = 1L;
        
        Number[] numbers = new Number[1];
        numbers[0] = 1.1D;
        
        Number a;
        System.out.println(a.getClass().getSimpleName());
        a = numbers[0];
        System.out.println("Number a = " + a);
        System.out.println(a.getClass().getSimpleName());
     }
    
    public void run() {
        Logger logger = Logger.getLogger(Contravariance_Covariance.class.getName());
        Contravariance_Covariance cc = new Contravariance_Covariance(logger);
        cc.execute();
    }
  
    public static class Animal {
        public void speak() {
            System.out.println("Animal speaks");
        }
    }
    
    public static class Dog extends Animal {
        @Override
        public void speak() {
            System.out.println("Dog barks");
        }
    }
    
    public static class Cat extends Animal {
        @Override
        public void speak() {
            System.out.println("Cat meows");
        }
    }
    
    static class BullDog extends Dog {
        @Override
        public void speak() {
            System.out.println("Dog bull dog");
        }
    }
    
    public static class PugDog extends Dog {
        @Override
        public void speak() {
            System.out.println("Dog pug dog");
        }
    }
}
