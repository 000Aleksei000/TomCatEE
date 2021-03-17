package com.beanValidation.customValidator;

import com.beanValidation.customValidatorWithComposit.BeanForCustomValidator;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "Servlet", value = "/customValid")
public class Servlet extends HttpServlet {
    @Inject
    Validator validator;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<ConstraintViolation<ClazzForValidate>> site = validator.validateValue(ClazzForValidate.class, "site", "adfasdf");
        for (ConstraintViolation<ClazzForValidate> violation : site) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        System.out.println("--------------------------------");
        Set<ConstraintViolation<ClazzForValidate>> site2 = validator.validateValue(ClazzForValidate.class, "site2", "https://mysite.com");
        for (ConstraintViolation<ClazzForValidate> violation : site2) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        System.out.println("--------------------------------");
        Set<ConstraintViolation<ClazzForValidate>> site3 = validator.validateValue(ClazzForValidate.class, "site3", "https://someothersite.com");
        for (ConstraintViolation<ClazzForValidate> violation : site3) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        System.out.println("--------------------------------");
        Set<ConstraintViolation<ClazzForValidate>> site4 = validator.validateValue(ClazzForValidate.class, "site4", "ftp://mysite.com:22");
        for (ConstraintViolation<ClazzForValidate> violation : site4) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }
        System.out.println("--------------------------------");
    }
}
