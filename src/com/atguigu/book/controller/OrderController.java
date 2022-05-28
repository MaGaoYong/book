package com.atguigu.book.controller;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 结账功能。（等同于添加订单）
 * @author adventure
 * @create 2022-05-25 15:37
 */
public class OrderController {

    private OrderService orderService;
    //结账
    public String checkout(HttpSession session){
        OrderBean orderBean = new OrderBean();

        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth();
        int day = now.getDate();
        int hours = now.getHours();
        int min = now.getMinutes();
        int sec = now.getSeconds();

//        UUID.randomUUID().toString()：32位的全球唯一码
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+year+month+day+hours+min+sec);

        orderBean.setOrderDate(now);

        User user = (User)session.getAttribute("currUser");
        orderBean.setOrderUser(user);

        orderBean.setOrderMoney(user.getCart().getTotalMoney());

        orderBean.setOrderStatus(0);

        //将新new的OrderBean添加到数据库中
        orderService.addOrderBean(orderBean);


        return "index";
    }

    //查看订单列表
    public String getOrderList(HttpSession session){
        User user = (User)session.getAttribute("currUser");

        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);

        session.setAttribute("currUser",user);

        return "order/order";
    }

}
