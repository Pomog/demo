package collections;

import java.util.ArrayList;
import java.util.List;

public class ArraysTrainings {
    public static void main(String[] args) {
        
        int[] intArray = {1, 2, 3}; // array is object, there are classes for every type of array
        System.out.println(intArray.getClass().getSimpleName());
        

        new Contravariance_Covariance().run();
    }
    
    static class Contravariance_Covariance {
        
        
        public void run(){
            List<? super Dog> dogs = new ArrayList<Animal>();
            dogs.add(new BullDog());
            dogs.add(new PugDog());

            System.out.println(dogs.get(0).getClass().getSimpleName());
            System.out.println(dogs.get(1).getClass().getSimpleName());
            
            List<BullDog> bullDogs = new ArrayList<>();
            BullDog testBullDog = new BullDog(){
                @Override
                public void speak() {
                    System.out.println("Test Bull Dog");
                }
            };
            bullDogs.add(new BullDog());
            bullDogs.add(testBullDog);
            
            covariance_reading(bullDogs);
            
            List<Cat> cats = new ArrayList<>();
            
            Cat catOne = new Cat();
            Cat catTwo = new Cat(){
                @Override
                public void speak(){
                    System.out.println("Test MEOW");
                }
           };
            cats.add(catOne);
            cats.add(catTwo);
            
            covariance_reading(cats);
        }
        
        public void covariance_reading (List<? extends Animal> animals) {
            animals.forEach(Animal::speak);
        }
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
