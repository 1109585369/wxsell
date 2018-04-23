package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;


    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1222");
        orderDetail.setOrderId("12334");
        orderDetail.setProductIcon("https:xxx.jpg");
        orderDetail.setProductId("111");
        orderDetail.setProductName("商品名称");
        orderDetail.setProductPrice(new BigDecimal(4));
        orderDetail.setProductQuantity(3);

        OrderDetail res=repository.save(orderDetail);
        Assert.assertNotNull(res);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetailList = repository.findByOrderId("11");

        Assert.assertNotEquals(0,orderDetailList);

    }
}