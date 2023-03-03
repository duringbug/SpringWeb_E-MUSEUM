package com.tjf.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.spring.service.MuseumsService;
import com.tjf.utils.CookieUtil;
import com.tjf.utils.SessionUtil;
import lombok.SneakyThrows;
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
 * @date 2023/1/7 16:19
 * @description:
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger LOGGER= LoggerFactory.getLogger(IndexController.class);
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
    @RequestMapping("searchAll")
    @ResponseBody
    public String searchAll(@RequestParam(value="search",defaultValue = "") String search) throws JsonProcessingException {
        return objectMapper.writeValueAsString(museumsService.searchMuseums(search));
    }
    @SneakyThrows
    @RequestMapping("online")
    @ResponseBody
    public String online(@RequestParam("id")int id, HttpServletRequest request, HttpServletResponse response){
        if(cookieUtil.getCookieValue("ONLINE",request)!=null){
            return objectMapper.writeValueAsString("ture");
        }
        else{
            return objectMapper.writeValueAsString("false");
        }
    }
    @RequestMapping(value = "notOnline",method = {RequestMethod.GET})
    @ResponseBody
    public  String notOnline(HttpServletRequest request,HttpServletResponse response){
        cookieUtil.refreshCookie("ONLINE",request,response,0);
        sessionUtil.setSession("USER_ID",null,request,response,0);
        return "OK";
    }
}
