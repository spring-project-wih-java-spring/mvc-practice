package reflection;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.anotation.Controller;

import java.util.HashSet;
import java.util.Set;

public class ReflectionTest {

    private static  final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("reflection");

        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class));

        logger.debug("beans : [{}]", beans);
    }
}
