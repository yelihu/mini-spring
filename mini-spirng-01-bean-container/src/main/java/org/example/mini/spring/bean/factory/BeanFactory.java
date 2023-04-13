package org.example.mini.spring.bean.factory;

/**
 * @author yelihu
 **/
public interface BeanFactory {

    /**
     * 含参获取Bean Instance
     *
     * @param beanName bean名称
     * @param args 构造函数需要的参数
     * @return
     */
    Object getBean(String beanName, Object... args);
}
