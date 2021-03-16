package com.tomEE;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.ExcludeClassInterceptors;
import jakarta.interceptor.InvocationContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Interceptor")
public class InterceptorClass extends HttpServlet {
    @Inject
    Beanzz beanzz;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        beanzz.doJob();
        beanzz.doJob2();
    }
}

class Interceptor {
    @AroundConstruct
    private void aroundConstruct(InvocationContext context) throws Exception {
        System.out.println("@AroundConstruct");
        context.proceed();
    }
    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception {
        System.out.println("@PostConstruct");
        context.proceed();
    }

    @AroundInvoke
    private Object aroundInvoke(InvocationContext invocationContext) {
        System.out.println("@AroundInvoke \nBefore method");
        Object obj = null;
        try {
            obj = invocationContext.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("@PreDestroy");
    }
}
@jakarta.interceptor.Interceptors(Interceptor.class)
@RequestScoped
class Beanzz {
    public Beanzz(){
        System.out.println("Construct");
    }



    public void doJob() {
        System.out.println("I am job");
    }
    @ExcludeClassInterceptors
    public void doJob2(){
        System.out.println("I am job2");
    }


}

