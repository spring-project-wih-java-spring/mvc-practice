package di_practice.di;

import java.util.Set;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClass;
    public BeanFactory(Set<Class<?>> preInstantiatedClass) {
        this.preInstantiatedClass = preInstantiatedClass;
    }
}
