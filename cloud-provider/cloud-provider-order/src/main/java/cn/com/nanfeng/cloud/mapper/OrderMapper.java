package cn.com.nanfeng.cloud.mapper;

import cn.com.nanfeng.cloud.model.po.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liutao
 * @date 2020/06/09
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 查询所有的订单
     * @return
     */
    List<Order> selectOrder();
}