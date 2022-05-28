package com.atguigu.book.dao;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-24 17:15
 */
public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
