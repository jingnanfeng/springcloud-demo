package cn.com.nanfeng.cloud.service;

import cn.com.nanfeng.cloud.common.CommonDto;
import cn.com.nanfeng.cloud.model.po.Order;

import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-09 22:30
 */
public interface IOrderService {


    /**
     * 查询当前订单信息
     * @param commonDto
     * @return
     */
    List<Order> getOrderByPage(CommonDto commonDto);

}
