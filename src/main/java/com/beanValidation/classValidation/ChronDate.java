package com.beanValidation.classValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {CheckChronologicalDates.class})
@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChronDate {
    String message() default "{date invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
