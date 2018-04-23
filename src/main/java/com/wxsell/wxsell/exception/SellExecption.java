package com.wxsell.wxsell.exception;

import com.wxsell.wxsell.Enum.ResultEnum;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/20
 * @Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class SellExecption extends RuntimeException {

    private Integer code;

    public SellExecption(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
