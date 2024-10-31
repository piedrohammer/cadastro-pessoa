package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.exceptions.CpfCnpjNotFoundException;
import com.example.cadastro_api.core.gateways.PessoaGateway;

public class FindByCpfPessoaUseCaseImp implements FindByCpfPessoaUseCase{

    private final PessoaGateway pessoaGateway;

    public FindByCpfPessoaUseCaseImp(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(String cpfCnpj) {
        Pessoa pessoa = pessoaGateway.findByCpfCnpj(cpfCnpj);
        if (pessoa == null) {
            throw new CpfCnpjNotFoundException("Não foi encontrado uma pessoa com CPF/CNPJ " + cpfCnpj + " cadastrado!");
        }
        return pessoa;
    }
}
