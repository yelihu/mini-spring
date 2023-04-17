package org.example.mini.spring.bean.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yelihu
 **/
@Data
public class BeanDefinition {
    /**
     * bean对象仅保存类的信息而不是instance
     */
    private Class<?> beanClass;

    /**
     * 需要填充的属性
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }
}
