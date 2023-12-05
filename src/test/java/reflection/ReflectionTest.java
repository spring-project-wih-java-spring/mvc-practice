package reflection;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.anotation.Controller;
import reflection.anotation.Service;
import reflection.model.User;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(Arrays.asList(Controller.class, Service.class));
        logger.debug("beans : [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> userClass = User.class;
        logger.debug(userClass.getName());
        logger.debug("User all declared fields: [{}]", Arrays.stream(userClass.getDeclaredConstructors()).collect(Collectors.toList()));
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("reflection");
        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
        return beans;
    }
}
