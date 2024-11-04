package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.exceptions.EmailAlreadyExistsException;
import com.example.cadastro_api.core.exceptions.NotFoundException;
import com.example.cadastro_api.core.gateways.PessoaGateway;

public class UpdatePessoaEmailUseCaseImp implements UpdatePessoaEmailUseCase {

    private final PessoaGateway pessoaGateway;

    public UpdatePessoaEmailUseCaseImp(PessoaGateway pessoaGateway) {
        this.pessoaGateway = pessoaGateway;
    }

    @Override
    public Pessoa execute(String cpfCnpj, String novoEmail) {
        Pessoa pessoa = pessoaGateway.findByCpfCnpj(cpfCnpj);
        if (pessoa == null) {
            throw new NotFoundException("Não existe uma pessoa com CPF/CNPJ " + cpfCnpj + " cadastrado!");
        }

        // Verificar se o novo email já está em uso
        if (pessoaGateway.existsByEmail(novoEmail)) {
            throw new EmailAlreadyExistsException("Email " + novoEmail + " já cadastrado por favor utilizar outro");
        }
        Pessoa pessoaAtualizada = pessoa.setEmail(novoEmail); // Usando setEmail para criar nova instância
        return pessoaGateway.updatePessoa(pessoaAtualizada);
    }
}

