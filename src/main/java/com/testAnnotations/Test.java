package com.testAnnotations;

import com.annotations.Init;
import com.annotations.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);
    }


    public static void inspectService(Class<?> service) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Annotation[] declaredAnnotations = service.getDeclaredAnnotations();
        for (Annotation annotation : declaredAnnotations) {
            if (annotation.annotationType().equals(Service.class)) {
                Method[] declaredMethods = service.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    Annotation[] declaredAnnotations1 = method.getDeclaredAnnotations();
                    for (Annotation annotation1 : declaredAnnotations1) {
                        if (annotation1.annotationType().equals(Init.class)) {
                            method.invoke(service.newInstance());
                        }
                    }
                }
            }
        }
    }
}
