package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.gateways.PessoaGateway;

import java.util.List;

public class GetAllPessoasUseCaseImp implements  GetAllPessoasUseCase {

    private final PessoaGateway pessoaGateway;

    public GetAllPessoasUseCaseImp(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public List<Pessoa> execute() {
        return pessoaGateway.obtainAllPessoas();
    }
}