package com.tjf.spring.dao;

import com.tjf.myBatis.mapper.UserMapper;
import com.tjf.myBatis.project.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:37
 * @description:
 */
@Repository("userDaoImpl1")
public class UserDaoImpl1 implements UserDao{
    @Qualifier("userMapperImpl1")
    @Autowired
    public UserMapper userMapper;

    public UserDaoImpl1() {
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDaoImpl1(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String toString() {
        return "UserDaoImpl1{" +
                "userMapper=" + userMapper +
                '}';
    }
    public User selectUser(int userid){
        return userMapper.selectUserById(userid);
    }
}
