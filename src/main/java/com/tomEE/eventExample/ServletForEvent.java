package com.tomEE.eventExample;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Event")
public class ServletForEvent extends HttpServlet {
    @Inject
    ServiceBook serviceBook;
    @Inject
    BookSubscriber bookSubscriber;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book new_book1 = new Book("New Book1");
        serviceBook.addBook(new_book1);
        serviceBook.addBook(new Book("New Book2"));
        serviceBook.addBook(new Book("New Book3"));
        serviceBook.removeBook(new_book1);
        int i = bookSubscriber.list.size();
//        System.out.println(i + " ");
        resp.getWriter().write(i+" ");
        resp.getWriter().write(bookSubscriber.list.get(0).getName() + " ");
    }
}
