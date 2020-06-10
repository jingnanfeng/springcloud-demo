package cn.com.nanfeng.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-09 22:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDto {

    /**
     * 关键字查询
     */
    private String keyWords;

    /**
     * 当前页
     */
    private String currentPage;

    /**
     * 总页数
     */
    private String pageSize;
}
