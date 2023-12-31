package di_practice.di;

import di_practice.annotation.Controller;
import di_practice.annotation.Service;
import di_practice.controller.UserController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BeanFactoryTest {
    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    void setUp() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        reflections = new Reflections("di_practice");
        Set<Class<?>> preInstantiatedClass = getTypesAnnotatedWith(Controller.class, Service.class);
        beanFactory = new BeanFactory(preInstantiatedClass);
    }

    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
        Set<Class<?>> beans = new HashSet<>();
        for(Class<? extends Annotation> annotation : annotations) {
            beans.addAll(reflections.getTypesAnnotatedWith(annotation));
        }
        return beans;
    }

    @Test
    void diTest() {
        UserController userController = beanFactory.getBean(UserController.class);
        Assertions.assertThat(userController).isNotNull();
        Assertions.assertThat(userController.getUserService()).isNotNull();
    }
}