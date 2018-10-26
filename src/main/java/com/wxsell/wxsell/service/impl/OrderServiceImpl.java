package com.wxsell.wxsell.service.impl;

import com.wxsell.wxsell.Enum.ResultEnum;
import com.wxsell.wxsell.dataobject.OrderDetail;
import com.wxsell.wxsell.dataobject.OrderMaster;
import com.wxsell.wxsell.dataobject.ProductInfo;
import com.wxsell.wxsell.dto.CartDTO;
import com.wxsell.wxsell.dto.OrderDTO;
import com.wxsell.wxsell.exception.SellExecption;
import com.wxsell.wxsell.repository.OrderDetailRepository;
import com.wxsell.wxsell.repository.OrderMasterRepository;
import com.wxsell.wxsell.service.OrderService;
import com.wxsell.wxsell.service.ProductService;
import com.wxsell.wxsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/20
 * @Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class OrderServiceImpl implements OrderService {


    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;



    /**
     * 创建订单
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();


        //List<CartDTO> cartDTOList=new ArrayList<>();

        //1.查询商品(数量，价格)
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if(productInfo==null){
                throw new SellExecption(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算订单总价
           orderAmount=orderDetail.getProductPrice()
                   .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                   .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

          //  CartDTO cartDTO=new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
          //   cartDTOList.add(cartDTO);
        }


        //3.写入订单数据库 (orderMaster和orderDetail)
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMasterRepository.save(orderMaster);

        //4.扣库存

        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productService.deCreateStock(cartDTOList);


       return null;
    }

    /**
     * 查询订单
     *
     * @param orderId
     */
    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    /**
     * 查询订单列表
     *
     * @param buyerOpenId
     * @param pageable
     */
    @Override
    public List<OrderDTO> finList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    /**
     * 取消订单
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 完结订单
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    /**
     * 支付订单
     *
     * @param orderDTO
     */
    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
