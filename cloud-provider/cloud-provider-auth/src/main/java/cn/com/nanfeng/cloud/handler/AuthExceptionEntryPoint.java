package cn.com.nanfeng.cloud.handler;

import cn.com.nanfeng.cloud.common.WrapMapper;
import cn.com.nanfeng.cloud.common.Wrapper;
import cn.com.nanfeng.cloud.exception.ExceptionEnum;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-07-16 19:25
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Throwable cause = e.getCause();
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        Wrapper<Object> wrap = null;
        //一个非法的token
        if (cause instanceof InvalidTokenException){
            wrap = WrapMapper.wrap(ExceptionEnum.SECURITY401.code(), ExceptionEnum.SECURITY401.message());

        }else {
             wrap = WrapMapper.wrap(ExceptionEnum.SECURITY401.code(), ExceptionEnum.SECURITY401.message());
        }
        String result = JSON.toJSONString(wrap);
        response.getWriter().write(result);
    }
}
