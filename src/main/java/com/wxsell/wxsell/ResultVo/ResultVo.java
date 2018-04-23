package com.wxsell.wxsell.ResultVo;

import lombok.Data;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/12
 * @Time: 21:08
 * http请求返回的最外层对象
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ResultVo<T> {


    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;



}
