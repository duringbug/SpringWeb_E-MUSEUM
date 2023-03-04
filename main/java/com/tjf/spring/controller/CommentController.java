package com.tjf.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.spring.service.MuseumsService;
import com.tjf.utils.CookieUtil;
import com.tjf.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin // 支持跨域访问
@Controller
public class CommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    SessionUtil sessionUtil;
    @Autowired
    CookieUtil cookieUtil;
    @Qualifier("museumsServiceImpl1")
    @Autowired
    MuseumsService museumsService;
    @Qualifier("objectMapperController")
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/Comment")
    public String Comment(HttpServletRequest request, HttpServletResponse response) {
        return "comment";
    }
}
