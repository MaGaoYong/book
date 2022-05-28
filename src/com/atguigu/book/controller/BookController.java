package com.atguigu.book.controller;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author adventure
 * @create 2022-05-24 17:26
 */
public class BookController {

    private BookService bookService;

    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";
    }

}
