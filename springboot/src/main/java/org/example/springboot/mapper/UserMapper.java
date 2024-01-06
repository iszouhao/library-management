package org.example.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有
    //@Select("select * from user")
    List<User> listUser();
}
