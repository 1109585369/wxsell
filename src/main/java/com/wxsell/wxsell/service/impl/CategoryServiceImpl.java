package com.wxsell.wxsell.service.impl;

import com.wxsell.wxsell.dataobject.ProductCategory;
import com.wxsell.wxsell.repository.ProductCategoryRepository;
import com.wxsell.wxsell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/10
 * @Time: 10:27
 * To change this template use File | Settings | File Templates.
 */

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
