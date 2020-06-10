package cn.com.nanfeng.cloud.web.controller;

import cn.com.nanfeng.cloud.common.CommonDto;
import cn.com.nanfeng.cloud.common.CommonResult;
import cn.com.nanfeng.cloud.model.po.Order;
import cn.com.nanfeng.cloud.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2020-06-09 22:54
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/getAllOrder")
    public CommonResult getAllOrder(CommonDto commonDto){
        List<Order> orderList = orderService.getOrderByPage(commonDto);
        return new CommonResult(200,"查询成功",orderList);
    }

}
