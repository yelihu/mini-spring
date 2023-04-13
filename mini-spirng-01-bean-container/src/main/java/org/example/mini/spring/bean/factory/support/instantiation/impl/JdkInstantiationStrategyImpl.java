package org.example.mini.spring.bean.factory.support.instantiation.impl;

import java.lang.reflect.Constructor;

import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.support.instantiation.InstantiationStrategy;

/**
 * 实例化策略 - JDK反射实现
 *
 * @author yelihu
 **/
public class JdkInstantiationStrategyImpl implements InstantiationStrategy {

    @Override
    public Object instantiate(String beanName, BeanDefinition bd, Constructor<?> constructor, Object[] args) {
        Class<?> clzz = bd.getBeanClass();
        Object beanInstance = null;
        try {
            if (constructor == null) {
                beanInstance = clzz.getDeclaredConstructor()
                    .newInstance();
            } else {
                //获取参数类型数组
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                //给出类型+参数 构建
                beanInstance = clzz.getDeclaredConstructor(parameterTypes)
                    .newInstance(args);
            }
        } catch (Throwable e) {
            throw new RuntimeException("faild to instantiate bean named " + beanName, e);
        }
        return beanInstance;
    }
}
