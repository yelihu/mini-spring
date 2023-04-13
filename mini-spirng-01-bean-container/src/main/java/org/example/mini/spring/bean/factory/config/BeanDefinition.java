package org.example.mini.spring.bean.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yelihu
 **/
@Data
@AllArgsConstructor
public class BeanDefinition {
    /**
     * bean对象仅保存类的信息而不是instance
     */
    private Class<?> beanClass;
}
