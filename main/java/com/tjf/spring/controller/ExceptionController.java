package com.tjf.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.utils.MyException.CheckFileSize;
import com.tjf.utils.MyException.FileEmpty;
import com.tjf.utils.MyException.MyFileSizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/7 13:07
 * @description: 对一些异常返回给前端信息
 */
@CrossOrigin//支持跨域访问
@ControllerAdvice
public class ExceptionController {
    @Qualifier("objectMapperController")
    @Autowired
    ObjectMapper objectMapper;
    @ExceptionHandler({MyFileSizeException.class})
    @ResponseBody//返回JSON
    public String fileSizeExceptionController(MyFileSizeException e, HttpServletRequest request) throws JsonProcessingException {
        if(e.getCause().getClass()==FileEmpty.class){
            return objectMapper.writeValueAsString("EMPTY");
        }
        else if (e.getCause().getClass()== CheckFileSize.class){
            return objectMapper.writeValueAsString("MAX");
        }
        else {
            return "WARN";
        }
    }
}
