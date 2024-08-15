package com.sss.test.dao;

import java.util.List;

import com.sss.test.entity.User;

public interface UserDao {

    public List<User> findAll();

    public User findByLoginIdAndPassword(String login_id, String password);

    public int insertUser(User user);

}