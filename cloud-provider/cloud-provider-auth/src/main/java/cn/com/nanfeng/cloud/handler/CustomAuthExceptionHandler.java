package cn.com.nanfeng.cloud.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 17:17
 */
@Component
@Slf4j
public class CustomAuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Resource
    private ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        Throwable cause = e.getCause();
        setResponse(response);
        if (cause instanceof InvalidTokenException){
            log.error("InvalidTokenException : [{}]" ,cause.getMessage());
            //Token无效
            response.getWriter().write(mapper.writeValueAsString(e.getMessage()));
        }else {
            log.error("AuthenticationException : NoAuthentication");
            //未授权
            response.getWriter().write(mapper.writeValueAsString(e.getMessage()));
        }
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        setResponse(response);
        //访问资源的用户权限不足
        log.error("AccessDeniedException : [{}]",e.getMessage());
        response.getWriter().write(mapper.writeValueAsString(e.getMessage()));
    }


    private void setResponse(HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // CORS "pre-flight" request
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control","no-cache");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");
    }
}
