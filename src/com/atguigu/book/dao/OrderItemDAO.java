package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderItem;

/**
 * @author adventure
 * @create 2022-05-25 15:07
 */
public interface OrderItemDAO {

    //添加订单
    void addOrderItem(OrderItem orderItem);
}
