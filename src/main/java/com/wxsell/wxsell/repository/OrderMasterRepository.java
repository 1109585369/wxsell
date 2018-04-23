package com.wxsell.wxsell.repository;

import com.wxsell.wxsell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/17
 * @Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    
    Page<OrderMaster> findBuyerOpenId(String buyerOpenId,Pageable pageable);


}

