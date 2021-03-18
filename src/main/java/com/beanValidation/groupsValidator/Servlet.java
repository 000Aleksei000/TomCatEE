package com.beanValidation.groupsValidator;

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

@WebServlet("/groupsValidator")
public class Servlet extends HttpServlet {
    @Inject
    Validator validator;
    @Inject
    Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.s1 = "";
        person.s2 = "";
        person.s3 = null;
        person.s4 = null;
        Set<ConstraintViolation<Person>> validate = validator.validate(person, Group3.class);
        if (validate.size() > 0) {
            for (ConstraintViolation<Person> violation : validate) {
                System.out.println(violation.getMessage());
                System.out.println(violation.getInvalidValue());
            }
        }
    }
}
