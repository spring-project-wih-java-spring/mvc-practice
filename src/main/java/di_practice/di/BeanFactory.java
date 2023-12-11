package di_practice.di;

import di_practice.annotation.Inject;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class BeanFactory {
    private final Set<Class<?>> preInstantiatedClass;
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        this.preInstantiatedClass = preInstantiatedClass;
        initialize();
    }

    private void initialize() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Class<?> clazz : preInstantiatedClass) {
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        // 생성자
        Constructor<?> constructor = findConstructor(clazz);

        // 파라미터
        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass : constructor.getParameterTypes()) {
            parameters.add(getParameterByClass(typeClass));
        }

        // 인스턴스 생성
        return constructor.newInstance(parameters.toArray());
    }

    private Constructor<?> findConstructor(Class<?> clazz) {
        return getConstructor(clazz);
    }

    private Constructor<?> getConstructor(Class<?> clazz) {
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(clazz);

        if (Objects.nonNull(constructor)) {
            return constructor;
        }

        return clazz.getConstructors()[0];
    }

    private Object getParameterByClass(Class<?> typeClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object instanceBean = getBean(typeClass);
        if (Objects.nonNull(instanceBean)) {
            return instanceBean;
        }

        return createInstance(typeClass);
    }



    public <T> T getBean(Class<T> requiredType) {
        return (T) beans.get(requiredType);
    }
}
