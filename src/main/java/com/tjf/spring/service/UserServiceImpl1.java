package com.tjf.spring.service;

import com.tjf.myBatis.project.User;
import com.tjf.spring.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:38
 */
@Service("userServiceImpl1")
public class UserServiceImpl1 implements UserService{
    private static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl1.class);
    @Qualifier("userDaoImpl1")
    @Autowired
    public UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl1() {
    }

    public UserServiceImpl1(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserServiceImpl1{" +
                "userDao=" + userDao +
                '}';
    }
    public User selectUser(int userid){
        User user=userDao.selectUser(userid);
        LOGGER.info("用户:"+user.getUserid()+"查询自身基本信息");
        return user;
    }
}
