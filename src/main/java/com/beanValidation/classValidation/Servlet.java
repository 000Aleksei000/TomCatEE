package com.beanValidation.classValidation;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

@WebServlet("/classValidation")
public class Servlet extends HttpServlet {
    @Inject
    Validator validator;
    @Inject
    Person person;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.setDeathDay(LocalDate.of(1995, 7, 5));
        person.setBirthDay(LocalDate.of(2095, 7, 5));
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        if (validate.size() > 0) {
            for (ConstraintViolation<Person> violation : validate) {
                System.out.println(violation.getMessage());
                System.out.println(violation.getInvalidValue());
            }
        }
    }
}
