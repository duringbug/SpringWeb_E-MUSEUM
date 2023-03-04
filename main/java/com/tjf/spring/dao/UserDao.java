package com.tjf.spring.dao;

import com.tjf.myBatis.project.User;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:37
 */
public interface UserDao {
    User selectUser(int userId);
    int initUser(User user);
}
