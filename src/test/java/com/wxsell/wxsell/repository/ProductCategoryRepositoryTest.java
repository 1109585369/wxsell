package com.wxsell.wxsell.repository;

import ch.qos.logback.core.rolling.RollingFileAppender;
import com.wxsell.wxsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 2018年4月9日19:54:57
 * yy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;


    @Test
    public void findByIdTest(){
        ProductCategory productCategory = repository.findById(1).orElse(null);
        System.out.println(productCategory.toString());
    }


    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("女生最爱",10);//repository.findById(2).orElse(null);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
        //productCategory.setCategoryType(10);
        //productCategory.setCategoryName("女生最爱");
        //productCategory.setCategoryType(3);
        //repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list=Arrays.asList(2,3,4);

        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }

}