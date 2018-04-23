package com.wxsell.wxsell.Enum;

import lombok.Getter;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

     private Integer code;

     private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
