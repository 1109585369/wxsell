package com.wxsell.wxsell.service;

import com.wxsell.wxsell.dataobject.OrderMaster;
import com.wxsell.wxsell.dto.OrderDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/20
 * @Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public interface OrderService {


    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);


    /**
     * 查询订单
     */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     */
    List<OrderDTO> finList(String buyerOpenId, Pageable pageable);

    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);
}
