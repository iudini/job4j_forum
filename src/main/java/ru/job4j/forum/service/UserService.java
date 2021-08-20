package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        users.put("user", User.of("user", "1234"));
    }

    public User findByName(String name) {
        return users.get(name);
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }
}
