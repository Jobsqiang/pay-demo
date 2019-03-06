package com.qiangjiang.demo.service.impl;

import com.qiangjiang.demo.dao.UserDao;
import com.qiangjiang.demo.model.User;
import com.qiangjiang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.add(user);
    }
}
