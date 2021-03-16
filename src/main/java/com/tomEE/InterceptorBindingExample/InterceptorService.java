package com.tomEE.InterceptorBindingExample;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptors;
import jakarta.interceptor.InvocationContext;
@One
@Two
public class InterceptorService {

    public void doJob(){
        System.out.println("doJob");
    }
}
