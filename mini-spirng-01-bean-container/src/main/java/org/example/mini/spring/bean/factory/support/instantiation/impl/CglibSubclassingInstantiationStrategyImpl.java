package org.example.mini.spring.bean.factory.support.instantiation.impl;

import java.lang.reflect.Constructor;

import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.support.instantiation.InstantiationStrategy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 使用Cglib实例化一个Bean Instance出来
 *
 * @author yelihu
 **/
public class CglibSubclassingInstantiationStrategyImpl implements InstantiationStrategy {

    @Override
    public Object instantiate(String beanName, BeanDefinition bd, Constructor<?> constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        //指定父类
        enhancer.setSuperclass(bd.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        return null == constructor ? enhancer.create() : enhancer.create(constructor.getParameterTypes(), args);
    }
}
