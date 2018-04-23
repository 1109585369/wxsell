package com.wxsell.wxsell.utils;

import com.wxsell.wxsell.ResultVo.ResultVo;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 11:33
 * To change this template use File | Settings | File Templates.
 */
public class ResultVOUtil {


    public static ResultVo success(Object object){
        ResultVo resultVo =new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success(){
        return  success(null);
    }

    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

}


