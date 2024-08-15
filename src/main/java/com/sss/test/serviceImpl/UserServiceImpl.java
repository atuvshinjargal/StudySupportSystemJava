package com.sss.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.test.dao.UserDao;
import java.util.List;
import com.sss.test.entity.User;
import com.sss.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User authentication(String login_id, String password) {
        return userDao.findByLoginIdAndPassword(login_id, password);
    }

    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
