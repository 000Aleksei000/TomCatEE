package com.beanValidation.inharitanceValidation;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "ServletForInheritance", value = "/servletForInheritance")
public class ServletForInheritance extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<ConstraintViolation<Child>> name = validator.validateValue(Child.class, "name", null);
        if (name.size() > 0) {
            for (ConstraintViolation<Child> violation : name) {
                System.out.println(violation.getMessage());
                System.out.println(violation.getInvalidValue());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
