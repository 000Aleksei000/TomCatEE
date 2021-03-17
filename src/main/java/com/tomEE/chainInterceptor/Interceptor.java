package com.tomEE.chainInterceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class Interceptor {
    /*@AroundConstruct
    private void aroundConstruct(InvocationContext invocationContext) throws Exception {
        System.out.println("@AroundConstruct");
        invocationContext.proceed();
    }*/

   /* @PostConstruct
    private void postConstruct(InvocationContext invocationContext) {
        System.out.println("@PostConstruct");
    }*/

    @AroundInvoke
    private Object aroundInvoke(InvocationContext invocationContext) throws Exception {
        System.out.println("@AroundInvoke one");
        return invocationContext.proceed();
    }

   /* @PreDestroy
    private void preDestroy() {
        System.out.println("@PreDestroy");
    }*/
}
