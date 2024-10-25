package collections;

import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class MyConsumer implements BiConsumer<Object, String> {
    private final String name;
    private final Logger logger;
    
    public MyConsumer(String name, Logger logger) {
        this.name = name;
        this.logger = logger;
    }
    
    @Override
    public void accept(Object o, String s) {
        logger.info("Hello class " + s + ". Are you " + name + "? " + o.getClass().getSimpleName() + " !!!");
    }
}
