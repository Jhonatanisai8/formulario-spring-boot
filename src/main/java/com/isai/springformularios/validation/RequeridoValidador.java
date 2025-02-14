package com.isai.springformularios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class RequeridoValidador
        implements ConstraintValidator<Requerido, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || !StringUtils.hasText(s)) {
            return false;
        }
        return true;
    }
}
