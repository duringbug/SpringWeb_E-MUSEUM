package com.tjf.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 00:22
 * @description:
 */
@Component
public class CookieUtil {
    @Autowired
    IpUtil ipUtil;
    private static final Logger LOGGER= LoggerFactory.getLogger(CookieUtil.class);
    public CookieUtil() {
    }
    @Nullable
    public String refreshCookie(String cookie_name, @NotNull HttpServletRequest request,HttpServletResponse response,int second){
        Cookie[] cookies=request.getCookies();
        int count=0;
        String cookie_value=null;
        if(cookies == null){LOGGER.debug("在<"+ipUtil.getIp(request)+">上的Cookie:"+cookie_name+"失效了或未创建");return null;}
        for(Cookie cookie:cookies){
            if(cookie.getName().equals(cookie_name)){
                cookie.setMaxAge(second);
                cookie_value=cookie.getValue();
                response.addCookie(cookie);
                count++;
            }
        }
        if(second<=0&&count==1){LOGGER.debug("cookie:<"+cookie_name+","+cookie_value+">"+"在<"+ipUtil.getIp(request)+">中删除了");}
        else if(count==1){LOGGER.debug(cookie_name+"在<"+ipUtil.getIp(request)+">刷新了"+cookie_name+",时间为"+second+"秒");}
        else {LOGGER.debug("在<"+ipUtil.getIp(request)+">上的Cookie:"+cookie_name+"失效了或未创建");}
        return cookie_value;
    }
    public boolean setCookie(String cookie_name, String cookie_value,@NotNull HttpServletRequest request, @NotNull HttpServletResponse response){
        Cookie cookie=new Cookie(cookie_name,cookie_value);
        cookie.setPath("/E-MUSEUM");
        response.addCookie(cookie);
        LOGGER.debug("在<"+ipUtil.getIp(request)+">中增加了Cookie:<"+cookie_name+","+cookie_value+">");
        return true;
    }
    public boolean setCookie(String cookie_name, String cookie_value,@NotNull HttpServletRequest request,  @NotNull HttpServletResponse response,int second){
        Cookie cookie=new Cookie(cookie_name,cookie_value);
        cookie.setMaxAge(second);
        cookie.setPath("/E-MUSEUM");
        response.addCookie(cookie);
        LOGGER.debug("在<"+ipUtil.getIp(request)+">中增加了Cookie:<"+cookie_name+","+cookie_value+">,时间为"+second+"秒");
        return true;
    }
    public String getCookieValue(String cookie_name, @NotNull HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        int count=0;
        String cookie_value=null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookie_name)) {
                    cookie_value = cookie.getValue();
                    count++;
                }
            }
            if (count == 1) {
                LOGGER.debug("<" + ipUtil.getIp(request) + ">查询到的Cookie:" + cookie_name + "值为" + cookie_value);
            } else {
                LOGGER.debug("<" + ipUtil.getIp(request) + ">未查询到的Cookie:" + cookie_name);
            }
        }
        return cookie_value;
    }
    public Cookie getCookieByName(String name,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        int count=0;
        Cookie cookieOut=null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookieOut = cookie;
                    count++;
                }
            }
            if (count == 1) {
                LOGGER.debug("<" + ipUtil.getIp(request) + ">查询到的Cookie:" + name + "值为" + cookieOut.getValue());
            } else {
                LOGGER.debug("<" + ipUtil.getIp(request) + ">未查询到的Cookie:" + name);
            }
        }
        return cookieOut;
    }
}
