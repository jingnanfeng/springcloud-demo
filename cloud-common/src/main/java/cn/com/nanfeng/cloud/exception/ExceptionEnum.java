package cn.com.nanfeng.cloud.exception;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-20 21:09
 */
public enum ExceptionEnum {

    /**
     * 用户不存在
     */
    AUTH10001(10001,"用户不存在"),
    AUTH10500(10500,"服务器内部错误"),
    SECURITY403(403,"抱歉，您没有该权限"),
    SECURITY401(401,"您输入的凭证非法或失效"),
    ;

    private int code;

    private String message;

    ExceptionEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    ExceptionEnum(){

    }

    public final int code(){
        return code;
    }

    public final String message(){
        return message;
    }



}
