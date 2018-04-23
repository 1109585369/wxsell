package com.wxsell.wxsell.Enum;

import lombok.Getter;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;


    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
