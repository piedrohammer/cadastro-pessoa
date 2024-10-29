package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;

public interface CreatePessoaUseCase {
    public Pessoa execute(Pessoa pessoa);
}
