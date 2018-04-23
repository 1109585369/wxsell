package com.wxsell.wxsell.service;

import com.wxsell.wxsell.dataobject.ProductInfo;
import com.wxsell.wxsell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/12
 * @Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {


    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询商品集合
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     *    加库存
     * @param cartDTOList
     */
    void inCreateStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     */
    void deCreateStock(List<CartDTO> cartDTOList);



    
}
