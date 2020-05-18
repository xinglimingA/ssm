package com.xlm.service;

import com.xlm.dao.UserDao;
import com.xlm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private UserDao userDao;

    public String hello(){
       List<User> list = userDao.getAllUser();
        User user = new User();

        user.setAddress("桥西区东窑子镇苏家桥村");
        user.setAdmin("1");
        user.setBan("0");
        user.setCity("张家口");
        user.setProvince("河北省");
        user.setName("邢利明");
        user.setTel("13001030701");
        user.setPassword("133153xlm");

        userDao.addUser(user);

        System.out.println(userDao.getAllUser());

        return "hello every one.";
    }
}