package com.atguigu.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * 购物车类
 * @author adventure
 * @create 2022-05-24 19:03
 */
public class Cart {

    //购物车中购物车项的集合，这个Map集合中的key是Book的id
    //为了验证集合中是否有这本书
    private Map<Integer,CartItem> cartItemMap;

    private Double totalMoney; //购物车的总金额
    private Integer totalCount; //购物车中购物项的数量
    private Integer totalBooKCount;//购物车中所有书本的总数量


    public Cart(){}

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {

        if (cartItemMap!=null && cartItemMap.size()>0){
            totalMoney = 0.0 ;
            BigDecimal bigDecimalPrice = null;
            BigDecimal bigDecimalBuyCount= null;
            //如果集合中有很多本书，则需要算出这些书的总和
            //先将Map中的元素存入Set中，然后遍历Set得到每一本书和它的数量
            Set<Map.Entry<Integer,CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer,CartItem> cartItemEntry : entries){
               CartItem cartItem = cartItemEntry.getValue();

//               bigDecimalPrice = new BigDecimal(cartItem.getBook().getPrice()+"");
//               bigDecimalBuyCount = new BigDecimal(cartItem.getBuyCount()+"");
//               BigDecimal bigDecimalTotalMoney = bigDecimalPrice.multiply(bigDecimalBuyCount);
//               BigDecimal bigDecimalTotalMonetSum = bigDecimalTotalMoney.add(bigDecimalTotalMoney);

//               totalMoney = bigDecimalTotalMonetSum.doubleValue();
                totalMoney = totalMoney + cartItem.getBook().getPrice() * cartItem.getBuyCount() ;
            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        totalCount = 0;
        //书的总数为Map的长度
        if (cartItemMap != null && cartItemMap.size()>0){
            totalCount = cartItemMap.size();
        }

        return totalCount;

    }

    public Integer getTotalBooKCount() {
        totalBooKCount = 0;
        if (cartItemMap != null && cartItemMap.size()>0){
           for (CartItem cartItem : cartItemMap.values()){
               totalBooKCount += cartItem.getBuyCount();
           }
        }
        return totalBooKCount;
    }

}
