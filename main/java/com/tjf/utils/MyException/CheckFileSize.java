package com.tjf.utils.MyException;

import com.tjf.utils.IpUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/7 11:16
 * @description:
 */
@Component
public class CheckFileSize extends MyFileSizeException{
    public CheckFileSize(){}
    public void throwMyFileSizeException(HttpServletRequest request, CommonsMultipartFile file) throws MyFileSizeException {
        System.out.println(file.getSize());
        if(file.getSize()>2*1024*1024) {
            throw new MyFileSizeException("用户:<" + new IpUtil().getIp(request) + ">上传的文件太大不被支持",this);
        }
    }
}
