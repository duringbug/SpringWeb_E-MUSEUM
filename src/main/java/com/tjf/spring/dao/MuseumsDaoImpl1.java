package com.tjf.spring.dao;

import com.tjf.myBatis.mapper.MuseumsMapper;
import com.tjf.myBatis.mapper.UserMapper;
import com.tjf.myBatis.project.Museums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:48
 * @description:
 */
@Repository("museumsDaoImpl1")
public class MuseumsDaoImpl1 implements MuseumsDao{
    @Qualifier("museumsMapperImpl1")
    @Autowired
    public MuseumsMapper museumsMapper;
    @Qualifier("userMapperImpl1")
    @Autowired
    public UserMapper userMapper;
    @Override
    public List<Museums> selectMuseumsByUsername(String username) {
        return museumsMapper.selectMuseumsByUsername(username);
    }

    @Override
    public List<Museums> selectMuseumsByUserid(int userid) {
        String username=userMapper.selectUserById(userid).getUsername();
        return museumsMapper.selectMuseumsByUsername(username);
    }
    public List<Museums> searchMuseums(String search) {
        return museumsMapper.searchMuseums(search);
    }
}
