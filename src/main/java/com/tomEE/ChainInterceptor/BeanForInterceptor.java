package com.tomEE.ChainInterceptor;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptors;
import jakarta.interceptor.InvocationContext;

import javax.naming.InitialContext;
@RequestScoped
@Interceptors({Interceptor.class, Interceptor2.class})
public class BeanForInterceptor {

    public BeanForInterceptor() {
        System.out.println("construct");
    }

    public void doSomething() {
        System.out.println("doSomething");
    }
    public void doSomething2() {
        System.out.println("doSomething2");
    }
}
