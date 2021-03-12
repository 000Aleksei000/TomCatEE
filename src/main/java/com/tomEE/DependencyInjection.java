package com.tomEE;

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

@WebServlet("/diExample")
public class DependencyInjection extends HttpServlet {
    @Inject
            @StudentAnnotation
    Person student;

    @Inject
    @WorkerAnnotation
    Person worker;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>");
        resp.getWriter().write("<br><h2>We can Inject Classes:</h2> <br>");
        resp.getWriter().write("1.<br>@Inject <br>Student student; <br>2.<br>");
        resp.getWriter().write("@Inject <br>\n" +
                "    public DependencyInjection(Student student) { <br>\n" +
                "        this.student = student; <br>\n" +
                "    } <br>3.<br>");
        resp.getWriter().write("@Inject <br>\n" +
                "    public void setStudent(Student student) {<br>\n" +
                "        this.student = student;<br>\n" +
                "    }<br>");
        resp.getWriter().write("<br>" + student.getName() + "<br>");
        resp.getWriter().write("<br>" + worker.getName() + "<br>");
        resp.getWriter().write("<br><h2>We can Inject Interface:</h2> <br>");
        resp.getWriter().write("");
        resp.getWriter().write("</html>");

    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface StudentAnnotation{}

interface Person{
    String getName();
    void setName(String s);
}

@StudentAnnotation
class Student implements Person{
    private String name;

    public String getName() {
        return "Student";
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@interface WorkerAnnotation{}

@WorkerAnnotation
class Worker implements Person{
    private String name;

    @Override
    public String getName() {
        return "Worker";
    }

    @Override
    public void setName(String s) {
        this.name = s;
    }
}
