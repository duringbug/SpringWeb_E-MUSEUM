package com.tjf.utils;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/6 17:33
 * @description:
 */
@Component
public class SessionUtil {
    @Autowired
    IpUtil ipUtil;
    private static final Logger LOGGER= LoggerFactory.getLogger(SessionUtil.class);
    public boolean setSession(String session_name, String session_value, @NotNull HttpServletRequest request, @NotNull HttpServletResponse response){
        HttpSession session=request.getSession();
        session.setAttribute(session_name,session_value);
        session.setMaxInactiveInterval(60*30);
        LOGGER.debug("在<"+ipUtil.getIp(request)+">中增加了Session:<"+session_name+","+session_value+">");
        return true;
    }
    public boolean setSession(String session_name, String session_value, @NotNull HttpServletRequest request, @NotNull HttpServletResponse response,int second){
        HttpSession session=request.getSession();
        session.setAttribute(session_name,session_value);
        session.setMaxInactiveInterval(second);
        LOGGER.debug("在<"+ipUtil.getIp(request)+">中刷新了Session:<"+session_name+","+session_value+">,时间为:"+second+"秒");
        return true;
    }
    public Object getValue(String session_name,@NotNull HttpServletRequest request, @NotNull HttpServletResponse response){
        Object result=request.getSession().getAttribute(session_name);
        return result;
    }
}
