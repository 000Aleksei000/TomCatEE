package com.tomEE.interceptorBindingExample;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
@Two
@Interceptor
public class InterceptorForBinding2 {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("@AroundInvoke 2");
        return context.proceed();
    }
}
