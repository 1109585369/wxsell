package com.wxsell.wxsell.dto;

import lombok.Data;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/23
 * @Time: 10:05
 * To change this template use File | Settings | File Templates.
 */
@Data
public class CartDTO {

    /**
     * 商品Id
     */
    private String productId;


    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
