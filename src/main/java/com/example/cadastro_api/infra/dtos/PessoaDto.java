package com.example.cadastro_api.infra.dtos;

import com.example.cadastro_api.core.enums.EnumTypePessoa;
import com.example.cadastro_api.core.validators.ValidCpfCnpj;
import com.example.cadastro_api.core.validators.ValidEmail;

public record PessoaDto(
        String nome,
        @ValidEmail // -> validação personalizada
        String email,
        @ValidCpfCnpj // -> validação personalizada
        String cpfCnpj,
        EnumTypePessoa type
) {
}