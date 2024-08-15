package com.sss.test.service;

import java.util.List;
import com.sss.test.entity.User;

public interface UserService {
    public List<User> findAll();

    public User authentication(String login_id, String password);

    public int insertUser(User user);
}
