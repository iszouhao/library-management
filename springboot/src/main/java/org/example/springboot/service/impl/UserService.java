package org.example.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot.controller.request.UserPageRequest;
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
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    /**
     * 分页查询用户方法
     *
     * @param userPageRequest 用户分页请求对象
     * @return 分页信息
     */
    public Object page(UserPageRequest userPageRequest) {
        // 开始分页
        PageHelper.startPage(userPageRequest.getPageNum(), userPageRequest.getPageSize());
        // 根据条件查询用户列表
        List<User> users = userMapper.listByCondition(userPageRequest);
        // 返回分页信息
        return new PageInfo<>(users);
    }
}
