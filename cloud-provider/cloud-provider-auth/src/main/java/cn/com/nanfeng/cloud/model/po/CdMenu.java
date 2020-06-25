package cn.com.nanfeng.cloud.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutao
 * @date 2020/06/20
 * @desc  菜单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CdMenu {
    private Integer id;

    private String menuName;

    private String menuUrl;

    private Integer parentId;

}