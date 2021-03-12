package com.tomEE;

import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DIAlternative")
public class DIAlternative extends HttpServlet {
    @Inject
    Parent child1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<html>");
        resp.getWriter().write("In beans.xml need write : <br> ");
        resp.getWriter().write("&lt;alternatives> <br>" +
                "        &lt;class>com.tomEE.Child1&lt;/class> <br>" +
                "    &lt;/alternatives> <br>");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<html>");
        resp.getWriter().write("</html>");
    }
}

interface Parent{
    public abstract String getName();
}

@Alternative
class Child1 implements Parent{
    @Override
    public String getName() {
        return "Child1";
    }
}

class Child2 implements Parent {
    @Override
    public String getName() {
        return "Child2";
    }
}