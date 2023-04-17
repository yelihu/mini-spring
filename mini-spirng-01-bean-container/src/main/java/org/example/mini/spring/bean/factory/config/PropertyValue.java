package org.example.mini.spring.bean.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author yelihu
 * @time 2023/4/17
 */
@Getter
@AllArgsConstructor
public class PropertyValue {
    private final String name;

    private final Object value;
}
