package cn.com.nanfeng.cloud.web;

import cn.com.nanfeng.cloud.common.WrapMapper;
import cn.com.nanfeng.cloud.common.Wrapper;
import cn.com.nanfeng.cloud.exception.BussinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 18:43
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Wrapper businessException(BussinessException e){
        log.error("业务异常={}",e.getMessage(),e);
        return WrapMapper.wrap(e.getCode(),e.getMessage());
    }

}
