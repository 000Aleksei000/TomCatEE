package com.beanValidation.classValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class CheckChronologicalDates implements ConstraintValidator<ChronDate, Person> {

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        return person.getBirthDay().isBefore(person.getDeathDay());
    }

    @Override
    public void initialize(ChronDate constraintAnnotation) {

    }
}
