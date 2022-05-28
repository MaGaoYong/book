package com.atguigu.book.service.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.dao.OrderDAO;
import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.OrderItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * 结账操作。（等同于添加订单）
 * @author adventure
 * @create 2022-05-25 15:25
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;


    @Override
    public void addOrderBean(OrderBean orderBean) {
        /*
        1) 订单表添加一条记录
        2) 订单详情表添加7条记录
        3) 购物车项表中需要删除对应的7条记录
         */
        //第一步：
        orderDAO.addOrderBean(orderBean); //执行完这一步，orderBean中的id是有值的

        //第二步：
        //orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()){

            //每封装出一个cartItem，就将其添加到orderItem中
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);

            orderItemDAO.addOrderItem(orderItem);
        }

        //第三步：
         for (CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }

    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);

        for (OrderBean orderBean : orderBeanList){
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }

        return orderBeanList;
    }
}
