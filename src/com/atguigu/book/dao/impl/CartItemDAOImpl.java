package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-24 18:54
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        String sql = "INSERT INTO t_cart_item VALUES(0,?,?,?) ";
        executeUpdate(sql,cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        String sql = "UPDATE t_cart_item SET buyCount = ? WHERE id = ? ";
        executeUpdate(sql,cartItem.getBuyCount(),cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        String sql = "SELECT * FROM t_cart_item WHERE userBean = ?";
        return executeQuery(sql,user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        String sql = "DELETE FROM t_cart_item WHERE id = ?";
        executeUpdate(sql,cartItem.getId());
    }
}
