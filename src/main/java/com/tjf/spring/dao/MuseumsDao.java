package com.tjf.spring.dao;

import com.tjf.myBatis.project.Museums;

import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:48
 */
public interface MuseumsDao {
    List<Museums> selectMuseumsByUsername(String username);
    List<Museums> selectMuseumsByUserid(int userid);
    List<Museums> searchMuseums(String search);
}
