package org.example.mini.spring.bean.factory.support;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.support.instantiation.InstantiationStrategy;
import org.example.mini.spring.bean.factory.support.instantiation.impl.CglibSubclassingInstantiationStrategyImpl;

import lombok.Getter;

/**
 * @author yelihu
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Getter
    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategyImpl();

    /**
     * 区别在于实例化bean的方式不同，这里需要重写bean创建方法
     *
     * @param beanName bean名称
     * @param beanDefinition bean元数据
     * @return bean实例
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object beanInstance = null;
        try {
            beanInstance = createBeanInstance(beanName, beanDefinition, args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        registerSingleton(beanName, beanInstance);

        return beanInstance;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?> constructor = null;
        if (args != null) {
            constructor = Arrays.stream(clazz.getDeclaredConstructors())
                .filter(c -> c.getParameterTypes().length == args.length)
                .findAny()
                .orElse(null);
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructor, args);

    }
}
