package com.tomEE.chainInterceptor;

import jakarta.enterprise.context.RequestScoped;
import jakarta.interceptor.Interceptors;

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
