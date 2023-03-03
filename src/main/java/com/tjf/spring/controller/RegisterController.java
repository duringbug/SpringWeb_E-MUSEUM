package com.tjf.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.spring.service.MuseumsService;
import com.tjf.utils.CookieUtil;
import com.tjf.utils.Mail.SendQQMail;
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
 * @date 2023/2/28 22:35
 * @description:
 */
@Controller
@RequestMapping("/Register")
public class RegisterController {
    private static final Logger LOGGER= LoggerFactory.getLogger(RegisterController.class);
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
    @RequestMapping("/sendMail")
    @ResponseBody
    public String sendMail(HttpServletRequest request, HttpServletResponse response,String qqMail) throws JsonProcessingException {
        SendQQMail sendQQMail=new SendQQMail();
        String number=sendQQMail.sendNumber("2365474936@qq.com");
        System.out.println(number);
        return objectMapper.writeValueAsString(number);
    }
}
