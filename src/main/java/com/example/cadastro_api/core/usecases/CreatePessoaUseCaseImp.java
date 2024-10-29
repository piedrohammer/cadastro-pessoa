package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.exceptions.BusinessException;
import com.example.cadastro_api.core.gateways.PessoaGateway;

public class CreatePessoaUseCaseImp implements  CreatePessoaUseCase {

    private final PessoaGateway pessoaGateway;

    public CreatePessoaUseCaseImp(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(Pessoa pessoa) {
        Pessoa pessoaExistente = pessoaGateway.findByCpfCnpj(pessoa.cpfCnpj());
        if(pessoaExistente != null) {
            throw new BusinessException("Já existe uma pessoa com CPF/CNPJ "+pessoa.cpfCnpj() + " cadastrado!");
        }
        return pessoaGateway.createPessoa(pessoa);
    }
}
