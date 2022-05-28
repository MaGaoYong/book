package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.OrderDAO;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author adventure
 * @create 2022-05-25 15:10
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        String sql = "INSERT INTO t_order VALUES(0,?,?,?,?,?)";
        int orderBeanId = super.executeUpdate(sql,
                                orderBean.getOrderNo(),
                                orderBean.getOrderDate(),
                                orderBean.getOrderUser().getId(),
                                orderBean.getOrderMoney(),
                                orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
        //思考：此处为什么需要接受executeUpdate的返回值，然后设置到orderBean中的id属性上？
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        String sql = "SELECT * FROM t_order WHERE orderUser = ?";
        return executeQuery(sql,user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "SELECT SUM(t3.buyCount) AS totalBookCount , t3.orderBean FROM " +
                "(" +
                "SELECT t1.id , t2.buyCount , t2.orderBean FROM t_order t1 INNER JOIN t_order_item t2 " +
                "ON t1.id = t2.orderBean WHERE t1.orderUser = ? " +
                ") t3 WHERE t3.orderBean = ? GROUP BY t3.orderBean" ;
        return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())[0]).intValue();
    }
}
