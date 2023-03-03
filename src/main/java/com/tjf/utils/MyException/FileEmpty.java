package com.tjf.utils.MyException;

import com.tjf.utils.IpUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/7 14:00
 * @description:
 */
@Component
public class FileEmpty extends MyFileSizeException{
    public FileEmpty(){}
    public void throwFileEmpty(HttpServletRequest request, CommonsMultipartFile file) throws MyFileSizeException {
        if (file.isEmpty() || file.getName().equals("")) {
            throw new MyFileSizeException("用户:<" + new IpUtil().getIp(request) + ">上传的文件上传的文件为空",this);
        }
    }
}
