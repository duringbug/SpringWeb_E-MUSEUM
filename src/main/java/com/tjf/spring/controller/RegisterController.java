package com.tjf.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.myBatis.project.User;
import com.tjf.spring.service.MuseumsService;
import com.tjf.spring.service.UserService;
import com.tjf.utils.CookieUtil;
import com.tjf.utils.Mail.SendQQMail;
import com.tjf.utils.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Qualifier("sendQQMail")
    @Autowired
    SendQQMail sendQQMail;
    @Qualifier("userServiceImpl1")
    @Autowired
    UserService userService;
    @RequestMapping("/sendMail")
    @ResponseBody
    public String sendMail(@RequestParam String qqMail) throws JsonProcessingException {
        String number=sendQQMail.sendNumber(qqMail);
        System.out.println(number);
        return objectMapper.writeValueAsString(number);
    }
    @RequestMapping(value="/sendInfo")
    @ResponseBody
    public String register(User user) throws JsonProcessingException {
        System.out.println((user));
        if(userService.initUser(user)==1) {
            return objectMapper.writeValueAsString("TRUE");
        }
        else {
            return objectMapper.writeValueAsString("FALSE");
        }
    }
}
