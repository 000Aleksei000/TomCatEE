package com.tomEE.interceptorBindingExample;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ServletForInterceptorBinding")
public class ServletForInterceptorBinding extends HttpServlet {
    @Inject
    InterceptorService interceptorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        interceptorService.doJob();
    }
}
