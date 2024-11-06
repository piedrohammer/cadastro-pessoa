package com.example.cadastro_api.core.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.trim().isEmpty()) {
            return false; // Retorna false para email vazio
        }

        // Expressão regular para validação do e-mail
        String emailPattern = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailPattern); // Retorna true ou false dependendo da validação
    }
}
