package org.example.mini.spring.bean.factory.config;

/**
 * @author yelihu
 **/
public interface SingletonBeanRegistry {

    /**
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);
}
