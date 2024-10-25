package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class CollectionsTrainings {
    public static void main(String[] args) {
        
        int[] intArray = {1, 2, 3}; // array is object, there are classes for every type of array
        System.out.println(intArray.getClass().getSimpleName());
        
        new Contravariance_Covariance().run();
    }
    
    static class Contravariance_Covariance {
        
        public void run() {
            List<? super Dog> dogs = new ArrayList<Animal>();
            dogs.add(new BullDog());
            dogs.add(new PugDog());
            dogs.add(new Dog());
            
            Map<Class<?>, BiConsumer<Object, String>> types = new HashMap<>();
            types.put(BullDog.class, new MyConsumer("BullDog"));
            types.put(PugDog.class,  new MyConsumer("PugDog"));
//            types.put(Dog.class, new MyConsumer("Dog"));
            
            System.out.println("Trying to replace IF with a Map");
            dogs.forEach(elem -> {
                Class<?> clazz = elem.getClass();
                BiConsumer<Object, String> consumer = types.get(clazz);
                if (consumer != null) {
                    consumer.accept(elem, elem.getClass().getSimpleName());
                } else {
                    System.out.println("No consumer found for " + clazz.getSimpleName());
                }
            });
            
            List<BullDog> bullDogs = new ArrayList<>();
            BullDog testBullDog = new BullDog() {
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
            Cat catTwo = new Cat() {
                @Override
                public void speak() {
                    System.out.println("Test MEOW");
                }
            };
            cats.add(catOne);
            cats.add(catTwo);
            
            covariance_reading(cats);
        }
        
        public void covariance_reading(List<? extends Animal> animals) {
            animals.forEach(Animal::speak);
        }
    }
    
    public static class MyConsumer implements BiConsumer<Object, String> {
        private final String name;
        
        public MyConsumer(String name) {
            this.name = name;
        }
        @Override
        public void accept(Object o, String s) {
            System.out.println("Hello class " + s + ". Are you " + name + "? " + o.getClass().getSimpleName() + " !!!");
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
