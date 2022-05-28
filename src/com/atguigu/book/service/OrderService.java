package com.atguigu.book.service;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-25 15:19
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
