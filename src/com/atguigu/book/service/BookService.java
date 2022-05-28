package com.atguigu.book.service;

import com.atguigu.book.pojo.Book;

import java.util.List;

/**
 * @author adventure
 * @create 2022-05-24 17:18
 */
public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
