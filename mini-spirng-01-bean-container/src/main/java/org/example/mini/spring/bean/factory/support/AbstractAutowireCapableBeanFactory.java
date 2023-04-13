package org.example.mini.spring.bean.factory.support;

import org.example.mini.spring.bean.factory.config.BeanDefinition;

/**
 * @author yelihu
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 区别在于实例化bean的方式不同，这里需要重写bean创建方法
     *
     * @param beanName bean名称
     * @param beanDefinition bean元数据
     * @return bean实例
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object beanInstance = null;
        try {
            //TODO::这里是后续内容迭代点[1]，不需要参数的构造器创建可以这样做，但是如果是有构造器呢？
            beanInstance = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //来自registry父类的方法，将实例注册到map当中去
        registerSingleton(beanName, beanInstance);

        return beanInstance;
    }
}
