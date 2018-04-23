package com.wxsell.wxsell.service.impl;

import com.wxsell.wxsell.Enum.ProductStatusEnum;
import com.wxsell.wxsell.Enum.ResultEnum;
import com.wxsell.wxsell.dataobject.ProductInfo;
import com.wxsell.wxsell.dto.CartDTO;
import com.wxsell.wxsell.exception.SellExecption;
import com.wxsell.wxsell.repository.ProductInfoRepository;
import com.wxsell.wxsell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/12
 * @Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    /**
     * 查询所有上架商品
     *
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    /**
     * 加库存
     *
     * @param cartDTOList
     */
    @Override
    public void inCreateStock(List<CartDTO> cartDTOList) {
        
    }

    /**
     * 减库存
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deCreateStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=repository.findById(cartDTO.getProductId()).orElse(null);
            if(productInfo==null){
                throw new SellExecption(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result>0){
                throw new SellExecption(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
