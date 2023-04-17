package org.example.mini.spring.bean.factory.config;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author yelihu
 * @time 2023/4/17
 */
public class PropertyValues {

    @Getter
    private final List<PropertyValue> propertyValueList = Lists.newArrayList();

    public void add(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public PropertyValue getPropertiesValue(String propertyName) {
        return propertyValueList.stream()
            .filter(propertyValue -> Objects.equals(propertyValue.getName(), propertyName))
            .findFirst()
            .orElse(null);
    }
}
