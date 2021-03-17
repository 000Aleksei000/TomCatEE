package com.beanValidation.customValidator;

import com.beanValidation.customValidator.CheckSiteUrl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.MalformedURLException;
import java.net.URL;

public class MyValidate implements ConstraintValidator<CheckSiteUrl, String> {

    String protocol;
    String host;
    int port;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.equals("")) {
            return true;
        }
        URL url;
        try {
            url = new URL(s);

        } catch (MalformedURLException e) {
            return false;
        }

        if (protocol != null && protocol.length()>0 && protocol.equals(url.getProtocol())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("protocol invalid").addConstraintViolation();
            return false;
        }

        if (host != null && host.length() > 0 && !host.equals(url.getHost())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();
            return false;
        }
        if (port != -1 && port != url.getPort()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("host invalid").addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(CheckSiteUrl constraintAnnotation) {
            protocol = constraintAnnotation.protocol();
            host = constraintAnnotation.host();
            port = constraintAnnotation.port();
    }
}
