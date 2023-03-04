package com.tjf.spring.service;

import com.tjf.myBatis.project.User;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:38
 * @description:
 */
public interface UserService {
    User selectUser(int userId);
    int initUser(User user);
}
