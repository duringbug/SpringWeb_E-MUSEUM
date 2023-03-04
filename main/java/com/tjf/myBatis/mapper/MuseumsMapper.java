package com.tjf.myBatis.mapper;

import com.tjf.myBatis.project.Museums;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:26
 */
public interface MuseumsMapper {
    List<Museums> selectMuseumsByUsername(@Param("username") String username);
    List<Museums> searchMuseums(@Param("search") String search);
}
