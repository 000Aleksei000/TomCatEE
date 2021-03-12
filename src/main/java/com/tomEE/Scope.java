package com.tomEE;

import jakarta.enterprise.context.*;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Scope", value = "/Scope")
public class Scope extends HttpServlet {

    @Inject
    MyBean myBean;
    @Inject
    ChangeMyBean changeMyBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        myBean.setI(5);
        changeMyBean.changeI();
        response.getWriter().write(myBean.getI() + "");
    }
}

//@ApplicationScoped
//@SessionScoped
//@RequestScoped
//@ConversationScoped
@Dependent
class MyBean {
    private int i;


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class ChangeMyBean {
    @Inject
    MyBean myBean;
    public void changeI() {
        myBean.setI(22);
    }
}