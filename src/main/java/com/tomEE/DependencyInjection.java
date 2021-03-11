package com.tomEE;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/diExample")
public class DependencyInjection extends HttpServlet {
    @Inject
    Student student;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        student.setName("Ivan");
        resp.getWriter().write("<html>");
        resp.getWriter().write("1.<br>@Inject <br>Student student; <br>2.<br>");
        resp.getWriter().write("@Inject <br>\n" +
                "    public DependencyInjection(Student student) { <br>\n" +
                "        this.student = student; <br>\n" +
                "    } <br>3.<br>");
        resp.getWriter().write("@Inject <br>\n" +
                "    public void setStudent(Student student) {<br>\n" +
                "        this.student = student;<br>\n" +
                "    }<br>");
        resp.getWriter().write("<br>" + student.getName());
        resp.getWriter().write("</html>");

    }
}
class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
