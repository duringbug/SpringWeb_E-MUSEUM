package com.tjf.utils.Filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 14:57
 * @description:处理get和post的过滤器
 */
@Component
public class EncodingFilterUtil implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //处理response编码
        HttpServletResponse myResponse=(HttpServletResponse) servletResponse;
        myResponse.setContentType("text/html;charset=UTF-8");
        //转型与协议相关的对象
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        //对request包装增强
        HttpServletRequest myRequest=new MyRequestWrapper(httpServletRequest);
        filterChain.doFilter(myRequest,myResponse);
    }
    @Override
    public void destroy() {

    }
}
