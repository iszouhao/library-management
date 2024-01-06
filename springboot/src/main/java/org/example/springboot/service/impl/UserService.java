package org.example.springboot.service.impl;

import org.example.springboot.entity.User;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
