package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/10
 * @Time: 15:16
 * To change this template use File | Settings | File Templates.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);


//    ProductInfo findOne(String productId);
//
//    List<ProductInfo> findUpAll(Integer productStatus);
//
//    List<ProductInfo> findAll(Pageable pageable);
//
//    ProductInfo save(ProductInfo productInfo);
    


}
