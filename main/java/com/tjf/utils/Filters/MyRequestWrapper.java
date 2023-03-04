package com.tjf.utils.Filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/5 15:50
 * @description:
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {
    private static final Logger LOGGER= LoggerFactory.getLogger(MyRequestWrapper.class);
    private HttpServletRequest request;
    private boolean hasEncode;
    public MyRequestWrapper(HttpServletRequest request){
        super(request);//必须写
        this.request=request;
    }
    @Override
    public Map getParameterMap(){
        //获得请求方法
        String method=request.getMethod();
        if(method.equalsIgnoreCase("post")){
            //post请求
            try{
                request.setCharacterEncoding("utf-8");
                LOGGER.debug("post转UTF_8成功");
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                LOGGER.warn(e.getMessage()+"<post请求转码失败>");
            }
        }
        else if(method.equalsIgnoreCase("get")){
            Map<String,String[]> parameterMap=request.getParameterMap();
            if(!hasEncode){//确保get手动编码只执行一次
                for(String parameterName :parameterMap.keySet()){
                    String[] values=parameterMap.get(parameterName);
                    if(values!=null){
                        for(int i=0;i<values.length;i++){
                            try{
                                //处理get乱码
                                values[i]=new String(values[i]
                                        .getBytes("ISO-8859-1"),"utf-8");
                            } catch (UnsupportedEncodingException e) {
                                LOGGER.warn(e.getMessage()+"<get转码失败>");
                            }
                        }
                    }
                }
                hasEncode=true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }
    @Override
    public String getParameter(String name){
        Map<String ,String[]> parameterMap=getParameterMap();
        String[] values=parameterMap.get(name);
        if(values==null){
            return null;
        }
        return values[0];//取参数第一个值
    }
    @Override
    public String[] getParameterValues(String name){
        Map<String,String[]> parameterMap=getParameterMap();
        String[] values=parameterMap.get(name);
        return values;
    }
}
