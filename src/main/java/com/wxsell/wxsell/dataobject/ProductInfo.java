package com.wxsell.wxsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/10
 * @Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
public class ProductInfo {

    /**
     * 商品ID
     */
    @Id
    private String productId;

    /**
     * 商品名称
     */
    private String productName;


    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    /**
     * 商品库存
     */
    private Integer productStock;


    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品图片
     */
    private String productIcon;

    /**
     * 商品状态
     */
    private Integer productStatus;

    /**
     * 商品类型
     */
    private Integer categoryType;

}
