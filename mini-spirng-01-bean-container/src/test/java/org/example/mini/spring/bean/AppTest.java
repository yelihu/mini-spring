package org.example.mini.spring.bean;

import static org.junit.Assert.assertTrue;

import org.example.mini.spring.bean.factory.config.BeanDefinition;
import org.example.mini.spring.bean.factory.config.BeanReference;
import org.example.mini.spring.bean.factory.config.PropertyValue;
import org.example.mini.spring.bean.factory.config.PropertyValues;
import org.example.mini.spring.bean.factory.support.DefaultListableBeanFactory;
import org.example.mini.spring.bean.factory.test.UserDao;
import org.example.mini.spring.bean.factory.test.UserService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test_apply_properties_to_bean() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        String userDao = "userDao";
        factory.registerBeanDefinition(userDao, new BeanDefinition(UserDao.class));
        PropertyValues pvs = new PropertyValues();
        pvs.add(new PropertyValue("userId", "2"));
        pvs.add(new PropertyValue(userDao, new BeanReference(userDao)));
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(UserService.class, pvs);

        String srvName = "userService";
        factory.registerBeanDefinition(srvName, userServiceBeanDefinition);

        UserService userService = (UserService)factory.getBean(srvName);
        String nameById = userService.getUserNameById();

        System.out.println(nameById);

    }

}
