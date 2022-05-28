package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-24 17:17
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

    @Override
    public List<Book> getBookList() {
        String sql = "SELECT * FROM t_book WHERE bookStatus=0";
        return executeQuery(sql);
    }

    @Override
    public Book getBook(Integer id) {
        return load("SELECT * FROM t_book WHERE id = ?",id);
    }
}
