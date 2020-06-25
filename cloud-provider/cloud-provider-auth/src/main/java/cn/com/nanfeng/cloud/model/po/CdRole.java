package cn.com.nanfeng.cloud.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutao
 * @date  2020/06/20
 * @desc  角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdRole {
    private Integer id;

    private String roleName;

    private String roleDesc;

}