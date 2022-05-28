package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-25 15:06
 */
public interface OrderDAO {

    //添加订单
    void addOrderBean(OrderBean orderBean);
    //获取指定用户的订单列表
    List<OrderBean> getOrderList(User user);

    //
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
