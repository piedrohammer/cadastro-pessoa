package com.example.cadastro_api.core.entities;

import com.example.cadastro_api.core.enums.EnumTypePessoa;

public record Pessoa(Long id, String nome, String email, String cpfCnpj, EnumTypePessoa type) {

    public Pessoa setEmail(String novoEmail) {
        return new Pessoa(this.id, this.nome, novoEmail, this.cpfCnpj, this.type);
    }
}

