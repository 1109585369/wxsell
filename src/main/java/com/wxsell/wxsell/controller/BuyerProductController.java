package com.wxsell.wxsell.controller;

import com.wxsell.wxsell.ResultVo.ResultVo;
import com.wxsell.wxsell.dataobject.ProductCategory;
import com.wxsell.wxsell.dataobject.ProductInfo;
import com.wxsell.wxsell.service.CategoryService;
import com.wxsell.wxsell.service.ProductService;
import com.wxsell.wxsell.utils.ResultVOUtil;
import com.wxsell.wxsell.vo.ProductInfoVo;
import com.wxsell.wxsell.vo.ProductVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/12
 * @Time: 21:02
 * To change this template use File | Settings | File Templates.
 */


@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVo list(){



        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询类目(一次性查询)
// 方法1：       List<Integer> categoryTypeList= new ArrayList<>();
//        for (ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法2:
        List<Integer> categoryList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);
                                 
        //3.数据拼装
        List<ProductVo> productVoList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());
            //productVo.setProductInfoVoList();
            List<ProductInfoVo>  productInfoVoList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo=new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }


        ResultVo resultVo=new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");

        resultVo.setData(productVoList);


        return ResultVOUtil.success(productVoList);
    }



}
