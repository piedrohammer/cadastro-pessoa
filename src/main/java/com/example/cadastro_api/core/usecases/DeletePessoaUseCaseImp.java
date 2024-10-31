package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.exceptions.NotFoundException;
import com.example.cadastro_api.core.gateways.PessoaGateway;

public class DeletePessoaUseCaseImp implements DeletePessoaUseCase{

    private final PessoaGateway pessoaGateway;

    public DeletePessoaUseCaseImp(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public void deleteByCpfCnpj(String cpfCnpj) {
        Pessoa pessoa = pessoaGateway.findByCpfCnpj(cpfCnpj);
        if (pessoa == null) {
            throw new NotFoundException(cpfCnpj);
        }
        pessoaGateway.deleteByCpfCnpj(cpfCnpj);
    }
}

