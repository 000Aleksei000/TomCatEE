package com.beanValidation.validateMessage;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.Set;

@WebServlet("/validateMessage")
public class Servlet extends HttpServlet {
        @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<MyURL>> url = validator.validateValue(MyURL.class, "url", "http://host.com:23");
        if(url.size()>0) {
            for (ConstraintViolation<MyURL> violation : url) {
                System.out.println(violation.getMessage());
            }
        }
    }
}
