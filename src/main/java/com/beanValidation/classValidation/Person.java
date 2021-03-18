package com.beanValidation.classValidation;

import java.time.LocalDate;
@ChronDate
public class Person {
    private LocalDate birthDay;
    private LocalDate deathDay;

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }
}
