package org.example.mini.spring.bean.factory.config;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

/**
 * @author yelihu
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private Map<String, Object> singletonMap = Maps.newHashMap();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(beanName));
        Preconditions.checkNotNull(singletonObject);

        singletonMap.put(beanName, singletonObject);
    }
}
