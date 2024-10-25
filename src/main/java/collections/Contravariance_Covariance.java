package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class Contravariance_Covariance {
    private final Logger logger;
    
    public Contravariance_Covariance(Logger logger) {
        this.logger = logger;
    }
    
    public void execute() {
        List<? super CollectionsTrainings.Dog> dogs = new ArrayList<>();
        dogs.add(new CollectionsTrainings.BullDog());
        dogs.add(new CollectionsTrainings.PugDog());
        dogs.add(new CollectionsTrainings.Dog());
        
        Map<Class<?>, BiConsumer<Object, String>> types = new HashMap<>();
        types.put(CollectionsTrainings.BullDog.class, new MyConsumer("BullDog", logger));
        types.put(CollectionsTrainings.PugDog.class, new MyConsumer("PugDog", logger));
//        types.put(CollectionsTrainings.Dog.class, new MyConsumer("Dog", logger));
        
        logger.info("Trying to replace IF with a Map");
        
        contravariance_reading(dogs, types, logger);
        
        List<CollectionsTrainings.Animal> animals = new ArrayList<>();
        animals.add(new CollectionsTrainings.Animal());
        animals.add(new CollectionsTrainings.BullDog());
        
        contravariance_reading(animals, types, logger);
        
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        
        contravariance_reading(objects, types, logger);
        
        List<CollectionsTrainings.BullDog> bullDogs = new ArrayList<>();
        CollectionsTrainings.BullDog testBullDog = new CollectionsTrainings.BullDog() {
            @Override
            public void speak() {
                System.out.println("Test Bull Dog");
            }
        };
        bullDogs.add(new CollectionsTrainings.BullDog());
        bullDogs.add(testBullDog);
        
        covariance_reading(bullDogs);
        
        List<CollectionsTrainings.Cat> cats = new ArrayList<>();
        CollectionsTrainings.Cat catOne = new CollectionsTrainings.Cat();
        CollectionsTrainings.Cat catTwo = new CollectionsTrainings.Cat() {
            @Override
            public void speak() {
                System.out.println("Test MEOW");
            }
        };
        cats.add(catOne);
        cats.add(catTwo);
        
        covariance_reading(cats);
    }
    
    public void covariance_reading(List<? extends CollectionsTrainings.Animal> animals) {
        animals.forEach(CollectionsTrainings.Animal::speak);
    }
    
    public void contravariance_reading(
            List<? super CollectionsTrainings.Dog> animals, Map<Class<?>,
            BiConsumer<Object, String>> types,
            Logger logger)
    {
        animals.forEach(elem -> {
            Class<?> clazz = elem.getClass();
            BiConsumer<Object, String> consumer = types.get(clazz);
            String className = clazz.getSimpleName();
            if (consumer != null) {
                consumer.accept(elem, className);
            } else {
                logger.info("No consumer found for " + className);
            }
        });
    }
}