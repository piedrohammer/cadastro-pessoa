package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;

public interface FindByCpfPessoaUseCase {
    public Pessoa execute(String cpfCnpj);
}
