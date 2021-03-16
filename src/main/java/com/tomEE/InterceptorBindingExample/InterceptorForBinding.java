package com.tomEE.InterceptorBindingExample;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
@One
@Interceptor
public class InterceptorForBinding {
    @AroundInvoke
    private Object aroundInvoke(InvocationContext context) throws Exception {
        System.out.println("@AroundInvoke 1");
        return context.proceed();
    }
}
