package org.example.mini.spring.bean.factory.support;

import java.util.Map;

import org.example.mini.spring.bean.factory.config.BeanDefinition;

import com.google.common.collect.Maps;

/**
 * @author yelihu
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = Maps.newHashMap();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition bd) {
        beanDefinitionMap.put(beanName, bd);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new RuntimeException("no bean named [" + beanName + "]! ");
        }
        return beanDefinition;
    }
}
