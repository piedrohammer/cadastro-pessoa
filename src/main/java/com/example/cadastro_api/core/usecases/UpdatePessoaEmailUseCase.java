package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;

public interface UpdatePessoaEmailUseCase {
    Pessoa execute(String cpfCnpj, String novoEmail);
}
