package com.tjf.myBatis.mapper;

import com.tjf.myBatis.project.Museums;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:28
 * @description:
 */
@Repository("museumsMapperImpl1")
public class MuseumsMapperImpl1 implements MuseumsMapper{
    @Qualifier("sqlSessionTemplateClass")
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private MuseumsMapper museumsMapper;
    @Override
    public List<Museums> selectMuseumsByUsername(String username) {
        museumsMapper=sqlSessionTemplate.getMapper(MuseumsMapper.class);
        return museumsMapper.selectMuseumsByUsername(username);
    }

    @Override
    public List<Museums> searchMuseums(String search) {
        museumsMapper=sqlSessionTemplate.getMapper(MuseumsMapper.class);
        return museumsMapper.searchMuseums(search);
    }
}
