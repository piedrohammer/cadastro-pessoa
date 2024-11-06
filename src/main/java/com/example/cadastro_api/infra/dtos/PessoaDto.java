package com.example.cadastro_api.infra.dtos;

import com.example.cadastro_api.core.enums.EnumTypePessoa;
import com.example.cadastro_api.core.validators.ValidCpfCnpj;
import com.example.cadastro_api.core.validators.ValidEmail;

public record PessoaDto(
        String nome,
        @ValidEmail
        String email,
        @ValidCpfCnpj
        String cpfCnpj,
        EnumTypePessoa type
) {
}