package com.ale.boot.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher matcher = PHONE_PATTERN.matcher(value);
        return matcher.matches();
    }
}
