package org.example.mini.spring.bean.factory.support;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.config.BeanReference;
import org.example.mini.spring.bean.factory.config.PropertyValue;
import org.example.mini.spring.bean.factory.config.PropertyValues;
import org.example.mini.spring.bean.factory.support.instantiation.InstantiationStrategy;
import org.example.mini.spring.bean.factory.support.instantiation.impl.CglibSubclassingInstantiationStrategyImpl;

import lombok.Getter;

/**
 * @author yelihu
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Getter
    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategyImpl();

    /**
     * 区别在于实例化bean的方式不同，这里需要重写bean创建方法
     *
     * @param beanName       bean名称
     * @param beanDefinition bean元数据
     * @return bean实例
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object beanInstance = null;
        try {
            //创建Bean实例
            beanInstance = createBeanInstance(beanName, beanDefinition, args);
            //对Bean实例里面的属性或者关联引入"@Autowire"的bean进行设置
            applyPropertyValues(beanName, beanDefinition, beanInstance);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        registerSingleton(beanName, beanInstance);

        return beanInstance;
    }

    /**
     * 对指定Bean名称的beanInstance进行值设置
     */
    private void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object beanInstance) {
        PropertyValues values = beanDefinition.getPropertyValues();
        try {
            List<PropertyValue> propertyValueList = values.getPropertyValueList();
            if (CollectionUtils.isNotEmpty(propertyValueList)) {
                propertyValueList.forEach(propertyValue -> {
                    String propertyValueName = propertyValue.getName();
                    Object value = propertyValue.getValue();

                    //is reference type
                    if (value instanceof BeanReference) {
                        BeanReference beanReference = (BeanReference)value;

                        //recursively replace value to referenced bean
                        value = getBean(beanReference.getBeanName());
                    }
                    BeanUtil.setFieldValue(beanInstance, propertyValueName, value);
                });
            }

        } catch (Throwable e) {
            throw new RuntimeException("Error setting property values: beanName=" + beanName);
        }
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?> constructor = null;
        if (args != null) {
            constructor = Arrays.stream(clazz.getDeclaredConstructors())
                .filter(c -> c.getParameterTypes().length == args.length)
                .findAny()
                .orElse(null);
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructor, args);

    }
}
