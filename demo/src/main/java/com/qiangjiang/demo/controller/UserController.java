package com.qiangjiang.demo.controller;

import com.qiangjiang.demo.model.User;
import com.qiangjiang.demo.service.SendMessageService;
import com.qiangjiang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SendMessageService sendMessageService;
    @RequestMapping("/hello")
    public void test(){
        System.out.println("hello boot");
    }

    @RequestMapping("/insert")
    public void insert(String str){
        User user = new User();
        user.setUserName(str);
        user.setPassWord("123456");
        user.setToken(UUID.randomUUID()+"");
        sendMessageService.userMessage(user);
        userService.addUser(user);
    }

}
