package com.wxsell.wxsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**类目
 * @Created with IntelliJ IDEA.
 * @author: Administrator
 * @Date: 2018/4/8
 * @Time: 20:45
 * To change this template use File | Settings | File Templates.
 */

@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }

    /**
     *  类目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**

     * 类目名称
     */
    private String categoryName;

    /**
     *   类目编号
     */
    private  Integer categoryType;


//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 修改时间
//
//     */
//    private Date updateTime;


   
    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }

}
