package com.tjf.spring.service;

import com.tjf.myBatis.project.Museums;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 22:54
 */
public interface MuseumsService {
    List<Museums> getMuseumsByCookie(Cookie cookie);
    int getMuseumsNumByCookie(Cookie cookie);
    List<Museums> searchMuseums(String search);
}
