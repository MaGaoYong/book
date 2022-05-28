package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.book.pojo.OrderItem;
import com.atguigu.myssm.basedao.BaseDAO;

/**
 * @author adventure
 * @create 2022-05-25 15:14
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item VALUES(0,?,?,?)";
        super.executeUpdate(sql,
                orderItem.getBook().getId(),
                orderItem.getBuyCount(),
                orderItem.getOrderBean().getId());
    }
}
