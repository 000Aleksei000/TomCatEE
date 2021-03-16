package com.tomEE;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ELBeans")
public class ELBeans extends HttpServlet {
    @Inject
    ExpLengBean expLengBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsf/BeanExample.xhtml");
        requestDispatcher.forward(req, resp);
    }
}
@RequestScoped
@Named
class ExpLengBean{
    private String s = "Hello World";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
