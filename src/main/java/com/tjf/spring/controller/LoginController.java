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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/18 23:56
 * @description:
 */
@Controller
@RequestMapping("/Login")
public class LoginController {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoginController.class);

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
    @RequestMapping("/")
    @ResponseBody
    public String Login(HttpServletRequest request, HttpServletResponse response){
        cookieUtil.setCookie("ONLINE","true",request,response,60*30);
        sessionUtil.setSession("USER_ID","0",request,response);
        return cookieUtil.getCookieValue("ONLINE",request);
    }
}
