package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail>  findByOrderId(String orderId);

}
