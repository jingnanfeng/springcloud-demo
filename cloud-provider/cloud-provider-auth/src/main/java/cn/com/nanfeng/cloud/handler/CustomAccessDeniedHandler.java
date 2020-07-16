package cn.com.nanfeng.cloud.handler;

import cn.com.nanfeng.cloud.common.WrapMapper;
import cn.com.nanfeng.cloud.common.Wrapper;
import cn.com.nanfeng.cloud.exception.BussinessException;
import cn.com.nanfeng.cloud.exception.ExceptionEnum;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liutao
 * @Title 自定义权限不足的处理
 * @Description
 * @date 2020-07-16 17:12
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {



    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        Wrapper<Object> wrap = WrapMapper.wrap(ExceptionEnum.SECURITY403.code(), ExceptionEnum.SECURITY403.message());
        String result = JSON.toJSONString(wrap);
        response.getWriter().write(result);
    }
}
