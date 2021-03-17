package com.beanValidation.customValidatorWithComposit;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull
@Size(min = 7)
@Pattern(regexp = "[A-Za-z0-9]*@[A-Za-z0-9]*\\.com")
@Constraint(validatedBy = {})
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEmail {
    String message() default "{email address doesn't look good}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
