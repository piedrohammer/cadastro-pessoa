package com.example.cadastro_api.core.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<ValidCpfCnpj, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("CPF/CNPJ não pode ser vazio").addConstraintViolation();
            return false;
        }

        String cleanedValue = value.replaceAll("[^0-9]", "");

        if (cleanedValue.length() == 11) {
            return isValidCPF(cleanedValue);
        }

        if (cleanedValue.length() == 14) {
            return isValidCNPJ(cleanedValue);
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("CPF/CNPJ deve ter 11 ou 14 dígitos").addConstraintViolation();
        return false;
    }

    // Método público para validação externa, sem ConstraintValidatorContext
    public boolean isCpfCnpjValid(String value) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }

        String cleanedValue = value.replaceAll("[^0-9]", "");

        if (cleanedValue.length() == 11) {
            return isValidCPF(cleanedValue);
        }

        if (cleanedValue.length() == 14) {
            return isValidCNPJ(cleanedValue);
        }

        return false;
    }

    private boolean isValidCPF(String cpf) {
        if (cpf.equals("00000000000") || cpf.length() != 11) {
            return false;
        }

        int sum = 0;
        int weight = 10;

        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }

        int firstCheck = (sum * 10) % 11;
        if (firstCheck == 10 || firstCheck == 11) {
            firstCheck = 0;
        }

        if (firstCheck != (cpf.charAt(9) - '0')) {
            return false;
        }

        sum = 0;
        weight = 11;

        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * weight--;
        }

        int secondCheck = (sum * 10) % 11;
        if (secondCheck == 10 || secondCheck == 11) {
            secondCheck = 0;
        }

        return secondCheck == (cpf.charAt(10) - '0');
    }

    private boolean isValidCNPJ(String cnpj) {
        if (cnpj.equals("00000000000000") || cnpj.length() != 14) {
            return false;
        }

        int sum = 0;
        int weight = 5;

        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weight;
            weight = (weight == 2) ? 9 : weight - 1;
        }

        int firstCheck = (sum % 11);
        firstCheck = (firstCheck < 2) ? 0 : 11 - firstCheck;

        if (firstCheck != (cnpj.charAt(12) - '0')) {
            return false;
        }

        sum = 0;
        weight = 6;

        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weight;
            weight = (weight == 2) ? 9 : weight - 1;
        }

        int secondCheck = (sum % 11);
        secondCheck = (secondCheck < 2) ? 0 : 11 - secondCheck;

        return secondCheck == (cnpj.charAt(13) - '0');
    }
}
