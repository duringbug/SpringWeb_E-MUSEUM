package com.tjf.spring.service;

import com.tjf.myBatis.project.Museums;
import com.tjf.spring.dao.MuseumsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:55
 * @description:
 */
@Service("museumsServiceImpl1")
public class MuseumsServiceImpl1 implements MuseumsService{
    private static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl1.class);
    @Qualifier("museumsDaoImpl1")
    @Autowired
    public MuseumsDao museumsDao;
    public List<Museums> getMuseumsByCookie(Cookie cookie){
        return museumsDao.selectMuseumsByUserid(Integer.parseInt(cookie.getValue()));
    }

    @Override
    public int getMuseumsNumByCookie(Cookie cookie) {
        return getMuseumsByCookie(cookie).size();
    }
    public List<Museums> searchMuseums(String search) {
        return museumsDao.searchMuseums(search);
    }
}
