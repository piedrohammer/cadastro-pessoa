package com.example.cadastro_api.infra.dtos;

import com.example.cadastro_api.core.enums.EnumTypePessoa;

public record PessoaDto(
        String nome,
        String email,
        String cpfCnpj,
        EnumTypePessoa type
) {
}