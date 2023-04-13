package org.example.mini.spring.bean.factory.support;

import org.example.mini.spring.bean.factory.BeanFactory;
import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.config.DefaultSingletonBeanRegistry;

/**
 * 需要实现获取bean实例的能力，同时继承了来自单例BeanRegistry对Bean的获取和注册能力
 *
 * @author yelihu
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) {

        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        return createBean(beanName, beanDefinition);
    }

    /**
     * 根据元数据创建bean实例
     *
     * @param beanName bean名称
     * @param beanDefinition bean元数据
     * @return bean 实例
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    /**
     * 获取BD bean的元数据
     *
     * @param beanName bean名称
     * @return bean的元数据
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
