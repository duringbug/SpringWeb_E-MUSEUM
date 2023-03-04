package com.tjf.myBatis.mapper;

import com.tjf.myBatis.project.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:28
 */
public interface UserMapper {
    User selectUserById(@Param("userId") int userId);
    int initUser(@Param("userid")int userid,@Param("username")String username,@Param("password")String password,@Param("create_time")String time,@Param("userQQmail")String userQQmail);
}
