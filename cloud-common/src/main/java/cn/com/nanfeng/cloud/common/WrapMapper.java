package cn.com.nanfeng.cloud.common;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-25 22:36
 */
public class WrapMapper {


    private WrapMapper(){

    }

    /**
     * wrap
     * @param code
     * @param message
     * @param result
     * @param <E>
     * @return new Wrapper
     */
    public static <E> Wrapper<E> wrap(int code,String message,E result){
        return new Wrapper<>(code,message,result);
    }

    /**
     * wrap
     * @param code
     * @param message
     * @param <E>
     * @return
     */
    public static <E> Wrapper<E> wrap(int code,String message){
        return new Wrapper<>(code,message,null);
    }

    /**
     * ok
     * @param <E>
     * @return
     */
    public static <E> Wrapper<E> ok(){
        return new Wrapper<>(Wrapper.SUCCESS_CODE,Wrapper.SUCCESS_MESSAGE,null);
    }

    /**
     * ok
     * @param result
     * @param <E>
     * @return
     */
    public static <E> Wrapper<E> ok(E result){
        return new Wrapper<>(Wrapper.SUCCESS_CODE,Wrapper.SUCCESS_MESSAGE,result);
    }


}
