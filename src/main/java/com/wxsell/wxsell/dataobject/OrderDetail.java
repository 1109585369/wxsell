package com.wxsell.wxsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单id
     */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /**商品数量 */
    private Integer productQuantity;

    /** 商品小图  */
    private String productIcon;



}
