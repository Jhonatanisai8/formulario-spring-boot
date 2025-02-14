package com.isai.springformularios.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador
        implements ConstraintValidator<Requerido, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return false;
        }
        return true;
    }
}
