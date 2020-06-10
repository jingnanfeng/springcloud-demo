package cn.com.nanfeng.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-09 22:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

}
