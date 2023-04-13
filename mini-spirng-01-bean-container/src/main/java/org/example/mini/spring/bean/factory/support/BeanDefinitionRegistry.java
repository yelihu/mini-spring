package org.example.mini.spring.bean.factory.support;

import org.example.mini.spring.bean.factory.config.BeanDefinition;

/**
 * TODO
 *
 * @author yelihu
 * @version V3.0
 * @since 2023/4/13 10:21 PM
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册一个bd
     *
     * @param beanName bean名称
     * @param bd bd元数据
     */
    void registerBeanDefinition(String beanName, BeanDefinition bd);

    /**
     * 获取一个bd元数据
     *
     * @param beanName bean名称
     * @return 元数据
     */
    BeanDefinition getBeanDefinition(String beanName);
}
