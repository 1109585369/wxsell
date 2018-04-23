package com.wxsell.wxsell.Enum;

import lombok.Getter;

/**
 * 商品状态
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/12
 * @Time: 19:21
 * To change this template use File | Settings | File Templates.
 */

@Getter
public enum  ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
