package com.beanValidation.beanValidationExample;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.executable.ExecutableValidator;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

@WebServlet("/beanValidationExample")
public class ServletForBeanValidationExample extends HttpServlet {
    @Inject
    BeanWithWalidation person;
   @Inject
   Validator validator;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        person.name = "Alex";
        person.age = 15;

//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BeanWithWalidation>> validate = validator.validate(person);
        if (validate.size() > 0) {
            System.out.println("some error occurred");
            for (ConstraintViolation<BeanWithWalidation> constraintViolation : validate) {
                System.out.println(constraintViolation.getMessage());
                System.out.println(constraintViolation.getInvalidValue());
            }
        }

//        Set<ConstraintViolation<BeanWithWalidation>> name = validator.validateProperty(person, "name");

       /* Set<ConstraintViolation<BeanWithWalidation>> constraintViolations = validator.validateValue(BeanWithWalidation.class, "name", "anton");
        if (constraintViolations.size() > 0) {
            System.out.println("anton is wrong");
        }*/

        try {
            Method setName = BeanWithWalidation.class.getMethod("setName", String.class);
            ExecutableValidator executableValidator = validator.forExecutables();
            Set<ConstraintViolation<Class<BeanWithWalidation>>> constraintViolations = executableValidator.validateParameters(BeanWithWalidation.class, setName, new Object[]{null});
            if (constraintViolations.size()>0){
                System.out.println("false");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



//        validatorFactory.close();
    }
}
