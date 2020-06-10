package com.livelo.application.client.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.apache.commons.lang3.StringUtils.isAlphaSpace;

public class AlphaSpaceConstraintValidator implements ConstraintValidator<AlphaSpace, String> {

    @Override
    public void initialize(AlphaSpace constraint) {
    }

    public boolean isValid(String text, ConstraintValidatorContext context) {
        return isAlphaSpace(text.replace(".", ""));
    }
}
