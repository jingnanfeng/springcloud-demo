package cn.com.nanfeng.cloud.exception;


import lombok.Data;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-20 21:04
 */
@Data
public class BussinessException extends RuntimeException {

    private static final long serialVersionUID = -7242858495609750003L;
    private int code;

    public BussinessException(int code,String message){
        super(message);
        this.code = code;
    }

    private BussinessException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.message());
        this.code = exceptionEnum.code();
    }
}
