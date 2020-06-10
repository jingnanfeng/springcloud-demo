package cn.com.nanfeng.cloud.service.impl;

import cn.com.nanfeng.cloud.common.CommonDto;
import cn.com.nanfeng.cloud.mapper.OrderMapper;
import cn.com.nanfeng.cloud.model.po.Order;
import cn.com.nanfeng.cloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-09 22:36
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrderByPage(CommonDto commonDto) {
        List<Order> orderList = orderMapper.selectOrder();
        return orderList;
    }
}
