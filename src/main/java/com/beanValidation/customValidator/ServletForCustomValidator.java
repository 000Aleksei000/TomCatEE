package com.beanValidation.customValidator;

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

@WebServlet("/customValidator")
public class ServletForCustomValidator extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<ConstraintViolation<BeanForCustomValidator>> email = validator.validateValue(BeanForCustomValidator.class, "email", "myMail@gmail.com");
        for (ConstraintViolation<BeanForCustomValidator> violation : email) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        Set<ConstraintViolation<BeanForCustomValidator>> email1 = validator.validateValue(BeanForCustomValidator.class, "email", "myMail@gmail.ru");
        for (ConstraintViolation<BeanForCustomValidator> violation : email1) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
    }
}
