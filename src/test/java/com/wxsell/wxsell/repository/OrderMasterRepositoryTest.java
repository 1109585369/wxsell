package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {


    @Autowired
    private OrderMasterRepository repository;

    private final  String  OPENID="110110";


    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenId(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(300));
        orderMaster.setBuyerPhone("110");
    }

    @Test
    public void findBuyerOpenId() {
        PageRequest request=new PageRequest(1,3);
        Page<OrderMaster> res=repository.findBuyerOpenId(OPENID,request);
        Assert.assertNotEquals(0,res.getTotalElements());
        System.out.println(res.getTotalElements());

    }



}