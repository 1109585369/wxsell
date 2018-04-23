package com.wxsell.wxsell.dataobject;

import com.wxsell.wxsell.Enum.OrderStatusEnum;
import com.wxsell.wxsell.Enum.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {


    /**
     * 订单Id
     */
    @Id
    private String orderId;


    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信Id
     */
    private String buyerOpenId;


    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为新下单
     */
    private Integer orderStatus=OrderStatusEnum.NEW.getCode();


    /**
     * 支付状态 默认0未支付
     */
    private Integer payStatusCode=PayStatusEnum.WAIT.getCode();

    /**
     *  创建时间 
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 关联订单明细表 使用传输对象代替
     */
    //private List<OrderDetail> orderDetailList;

}

