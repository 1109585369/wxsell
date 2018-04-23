package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private  ProductInfoRepository productInfoRepository;


    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("商品1");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setCategoryType(2);
        productInfo.setProductIcon("https://xxxx.jpg");
        productInfo.setProductStock(10);
        productInfo.setProductStatus(0);
        productInfo.setProductDescription("描述1");
        Assert.assertNotNull(productInfoRepository.save(productInfo));
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfos.size());
    }
}