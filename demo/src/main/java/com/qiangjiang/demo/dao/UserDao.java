package com.qiangjiang.demo.dao;

import com.qiangjiang.demo.mapper.UserMapper;
import com.qiangjiang.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public void add(User user){
        userMapper.insert(user);
    }
}
