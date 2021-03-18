package com.beanValidation.customValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MyValidate.class})
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckSiteUrl {
    String message() default "{jakarta.validation.Constraint.url.port.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int port() default -1;

    String host() default "";

    String protocol() default "";
}
