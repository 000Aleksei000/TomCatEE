package com.tomEE;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WebServlet("/DIProducers")
public class DIProducers extends HttpServlet {

    @Inject
    @S2
    String s;
    @Inject
    int i;
    @Inject
    double d;
    @Inject
    Car car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(s + ", " + i + ", " + d + ", " + car.name);
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface S2 {
}

class Producer {
    @Produces
    String s = "HelloWorld";
    @Produces
    @S2
    String s2 = "I am Alex";
    @Produces
    int i = 5;

    @Produces
    double getDouble() {
        return 1 + 3.3 + 5.8;
    }

    @Produces
    Car getCar() {
        return new Car("Ferrari");
    }
}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }
}
