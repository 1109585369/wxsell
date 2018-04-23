package com.wxsell.wxsell.service.impl;

import com.wxsell.wxsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo=productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfo=productService.findUpAll();
        Assert.assertNotEquals(0,productInfo);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> productInfos=productService.findAll(pageRequest);
        System.out.println(productInfos.getTotalPages());
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("商品1");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setCategoryType(2);
        productInfo.setProductIcon("https://xxxx.jpg");
        productInfo.setProductStock(10);
        productInfo.setProductStatus(0);
        productInfo.setProductDescription("描述1");
        Assert.assertNotNull(productService.save(productInfo));

    }
}