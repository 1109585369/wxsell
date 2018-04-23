package com.wxsell.wxsell.utils;

import java.util.Random;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/20
 * @Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class KeyUtil {


    /**
     * 生成唯一主键
     * 格斯:时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        System.currentTimeMillis();
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
