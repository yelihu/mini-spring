package org.example.mini.spring.bean.factory.test;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author yelihu
 * @time 2023/4/17
 */
public class UserDao {

    private static Map<String, String> repository = Maps.newHashMap();

    static {
        repository.put("1", "jack");
        repository.put("2", "pony");
        repository.put("3", "magic");
        repository.put("4", "lily");
        repository.put("5", "mike");
        repository.put("6", "jessey");
    }

    public String getUserNameById(String userId) {
        return repository.get(userId);
    }
}
