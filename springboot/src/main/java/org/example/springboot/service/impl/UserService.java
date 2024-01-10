package org.example.springboot.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.springboot.controller.request.UserPageRequest;
import org.example.springboot.entity.User;
import org.example.springboot.mapper.UserMapper;
import org.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    //查询所有用户
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

    // 新增用户方法
    @Override
    public void save(User user) {
        Date date = new Date();
        //当作卡号来处理
        user.setUsername(DateUtil.format(date, "yyyyMMdd")+IdUtil.fastSimpleUUID());
        userMapper.save(user);
    }

    // 编辑用户方法
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    //更新用户
    @Override
    public void update(User user) {
        user.setUpdatetime(new Date());
        userMapper.updateById(user);
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }
}
