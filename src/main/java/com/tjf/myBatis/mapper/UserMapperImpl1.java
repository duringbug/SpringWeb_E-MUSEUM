package com.tjf.myBatis.mapper;

import com.tjf.myBatis.project.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:29
 * @description:
 */
@Repository("userMapperImpl1")
public class UserMapperImpl1 implements UserMapper {
    @Qualifier("sqlSessionTemplateClass")
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    private UserMapper userMapper;

    @Override
    public User selectUserById(int userId) {
        userMapper=sqlSessionTemplate.getMapper(UserMapper.class);
        return userMapper.selectUserById(userId);
    }
}
