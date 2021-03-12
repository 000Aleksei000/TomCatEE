package com.tomEE;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/disposers")
public class Disposers extends HttpServlet {
    @Inject
    Automobile automobile;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(automobile.name);

    }
}

class Produce {
    @Produces
    Automobile getCar() {
        return new Automobile("Lada");
    }

    public void clean(@Disposes Automobile automobile) {
        automobile.clean();
    }
}

class Automobile {
    String name;

    public Automobile(String name) {
        this.name = name;
    }

    public void clean() {
        System.out.println("Automobile method clean ");
    }
}
