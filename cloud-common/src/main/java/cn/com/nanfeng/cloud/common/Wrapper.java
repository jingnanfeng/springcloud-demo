package cn.com.nanfeng.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 18:47
 */
@Data
public class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = -4081594340168833782L;

    /**
     * 成功码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功信息
     */
    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * code
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 结果数据
     */
    private T result;

    Wrapper(int code,String message,T result){
        super();
        this.code(code).message(message).result(result);
    }

    /**
     * set the code
     * @param code
     * @return this
     */
    private Wrapper<T> code(int code){
        this.setCode(code);
        return this;
    }

    /**
     * set the message
     * @param message
     * @return this
     */
    private Wrapper<T> message(String message){
        this.setMessage(message);
        return this;
    }

    private Wrapper<T> result(T result){
        this.setResult(result);
        return this;
    }



}
