package com.wxsell.wxsell.Enum;

import lombok.Getter;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/20
 * @Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存异常"),
    ;

    private  Integer code;

    private String message;
    
    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
