package com.tjf.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjf.utils.MyException.CheckFileSize;
import com.tjf.utils.MyException.FileEmpty;
import com.tjf.utils.MyException.MyFileSizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/6 23:45
 * @description:
 */
@CrossOrigin//支持跨域访问
@Controller
@RequestMapping("")
public class FileController {
    @Autowired
    CheckFileSize checkFileSize;
    @Autowired
    FileEmpty fileEmpty;
    @Qualifier("objectMapperController")
    @Autowired
    ObjectMapper objectMapper;
    private static final Logger LOGGER= LoggerFactory.getLogger(FileController.class);
    @RequestMapping("/")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/upload1")
    @ResponseBody
    public String upload1(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException, MyFileSizeException {
        checkFileSize.throwMyFileSizeException(request,file);//抛异常
        fileEmpty.throwFileEmpty(request,file);
        LOGGER.info("文件大小为"+String.valueOf(file.getSize()));
        //文件名
        String filename=file.getOriginalFilename();
        //文件名为空回首页
        if("".equals(filename)){
            return "admin";
        }
        String path=request.getServletContext().getRealPath("/upload");
        File realPath=new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件保存路径：realPath
        InputStream is=file.getInputStream();
        OutputStream os=new FileOutputStream(new File(realPath,filename));
        //读取写出
        int len=0;
        byte[] buffer=new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        LOGGER.info("<"+filename+">文件保存在"+realPath+"/"+filename+"下");
        return objectMapper.writeValueAsString("SUCCESS");
    }
    @RequestMapping("upload2")
    @ResponseBody
    public String upload2(@RequestParam("file" )CommonsMultipartFile file,HttpServletRequest request) throws IOException, MyFileSizeException {
        checkFileSize.throwMyFileSizeException(request,file);//抛异常
        fileEmpty.throwFileEmpty(request,file);
        String filename=file.getOriginalFilename();
        //上传路径
        String path=request.getServletContext().getRealPath("/upload");
        File realPath=new File(path);
        if(!realPath.exists()){
            realPath.mkdir();
        }
        file.transferTo(new File(realPath+"/"+filename));
        System.out.println(filename);
        LOGGER.info("<"+filename+">文件保存在"+realPath+"/"+filename+"下");
        return objectMapper.writeValueAsString("SUCCESS");
    }
}
