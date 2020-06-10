package cn.com.nanfeng.cloud.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 购买数量
     */
    private Integer count;

    /**
     * 价格
     */
    private BigDecimal money;

    /**
     * 0创建中1完成
     */
    private Integer status;

}