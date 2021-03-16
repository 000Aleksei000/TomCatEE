package com.tomEE;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LiveCycleBean")
public class LiveCycle extends HttpServlet {
    @Inject
    LiveCycleBean liveCycleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        liveCycleBean.doJob();
        liveCycleBean.doJob2();
    }
}

class LiveCycleBean {
    public LiveCycleBean (){
        System.out.println("Construct LiveCycleBean");
    }
    @PostConstruct
    private void postConstruct(){
        System.out.println("@PostConstruct");
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext invocationContext) {
        System.out.println("@AroundInvoke \n Before method");
       Object obj = null;
        try {
            obj = invocationContext.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void doJob() {
        System.out.println("I am job");
    }
    public void doJob2(){
        System.out.println("I am job2");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("@PreDestroy");
    }
}
