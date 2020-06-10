package cn.com.nanfeng.cloud.web;

import cn.com.nanfeng.cloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liutao
 * @Title
 * @Description 全局异常
 * @date 2020-06-09 22:41
 */
@Slf4j
@RestControllerAdvice
public class GlobaExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResult businessException(Exception e){
        log.info("业务异常 = [{}]",e.getMessage(),e);
        return new CommonResult(500,e.getMessage());
    }
}
