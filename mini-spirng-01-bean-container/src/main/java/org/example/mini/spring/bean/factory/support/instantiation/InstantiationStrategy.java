package org.example.mini.spring.bean.factory.support.instantiation;

import java.lang.reflect.Constructor;

import org.example.mini.spring.bean.factory.config.BeanDefinition;

/**
 * 实例化策略接口
 *
 * @author yelihu
 * @version V3.0
 * @since 2023/4/13 10:26 PM
 */
public interface InstantiationStrategy {
    /**
     * 根据构造函数和参数以及Bean元数据实例化一个Bean Instance出来
     *
     * @param beanName bean名称
     * @param bd bean元数据定义
     * @param constructor 构造函数
     * @param args 构造函数所需参数
     * @return
     */
    Object instantiate(String beanName, BeanDefinition bd, Constructor<?> constructor, Object[] args);
}
