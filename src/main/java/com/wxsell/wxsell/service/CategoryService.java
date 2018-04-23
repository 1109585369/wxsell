package com.wxsell.wxsell.service;

import com.wxsell.wxsell.dataobject.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/10
 * @Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
