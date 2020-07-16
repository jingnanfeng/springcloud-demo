package cn.com.nanfeng.cloud.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-07-15 18:44
 */
@Data
@Builder
public class UserVO {

    private Integer id;

    private String username;

    private String email;
}
