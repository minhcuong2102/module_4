package com.codegym.dao;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setAge(10);
        user1.setName("John");
        user1.setAccount("john");
        user1.setEmail("john@codegym.vn");
        user1.setPassword("123456");
        users.add(user1);

        User user2 = new User();
        user2.setAge(15);
        user2.setName("Bill");
        user2.setAccount("bill");
        user2.setEmail("bill@codegym.vn");
        user2.setPassword("123456");
        users.add(user2);

        User user3 = new User();
        user3.setAge(16);
        user3.setName("Mike");
        user3.setAccount("mike");
        user3.setEmail("mike@codegym.vn");
        user3.setPassword("123456");
        users.add(user3);
    }

    public static User checkLogin(Login login) {
        for (User u : users) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
