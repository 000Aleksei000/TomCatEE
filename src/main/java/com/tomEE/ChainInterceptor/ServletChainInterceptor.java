package com.tomEE.ChainInterceptor;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ChainInterceptor")
public class ServletChainInterceptor extends HttpServlet {
    @Inject
    BeanForInterceptor beanForInterceptor;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        beanForInterceptor.doSomething();
        beanForInterceptor.doSomething2();
    }
}
