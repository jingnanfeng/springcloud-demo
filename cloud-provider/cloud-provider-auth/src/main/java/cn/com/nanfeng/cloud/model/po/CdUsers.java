package cn.com.nanfeng.cloud.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutao
 * @date 2020/06/20
 * @desc  用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdUsers {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer status;

}