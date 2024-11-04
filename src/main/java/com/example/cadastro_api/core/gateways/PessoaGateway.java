package com.example.cadastro_api.core.gateways;

import com.example.cadastro_api.core.entities.Pessoa;

import java.util.List;

public interface PessoaGateway {

    Pessoa createPessoa(Pessoa pessoa);

    Pessoa findByCpfCnpj(String cpfCnpj);

    List<Pessoa> obtainAllPessoas();

    void deleteByCpfCnpj(String cpfCnpj);

    Pessoa updatePessoa(Pessoa pessoa);

    boolean existsByEmail(String email); // Verifica se o email já existe
}
