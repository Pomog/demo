package collections;

import java.util.logging.Logger;

public class CollectionsTrainings {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        System.out.println(intArray.getClass().getSimpleName());
        
        new CollectionsTrainings().run();
    }
    
    public void run() {
        Logger logger = Logger.getLogger(Contravariance_Covariance.class.getName());
        Contravariance_Covariance cc = new Contravariance_Covariance(logger);
        cc.execute();
    }
  
    static class Animal {
        public void speak() {
            System.out.println("Animal speaks");
        }
    }
    
    static class Dog extends Animal {
        @Override
        public void speak() {
            System.out.println("Dog barks");
        }
    }
    
    static class Cat extends Animal {
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
    
    static class PugDog extends Dog {
        @Override
        public void speak() {
            System.out.println("Dog pug dog");
        }
    }
}
