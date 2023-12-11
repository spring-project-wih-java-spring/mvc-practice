package di_practice.di;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClass;
    private Map<Class<?>, Object> beans=  new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClass) {
        this.preInstantiatedClass = preInstantiatedClass;
    }

    public <T> T getBean(Class<T> requiredType) {
        return (T) beans.get(requiredType);
    }
}
