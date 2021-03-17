package com.tomEE.chainInterceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class Interceptor2 {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext invocationContext) throws Exception {
        System.out.println("@AroundInvoke two");
        return invocationContext.proceed();
    }
}
