package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.exceptions.BusinessException;
import com.example.cadastro_api.core.exceptions.EmailError;
import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.core.validators.CpfCnpjValidator;
import com.example.cadastro_api.core.validators.EmailValidator;

public class CreatePessoaUseCaseImp implements CreatePessoaUseCase {

    private final PessoaGateway pessoaGateway;
    private final CpfCnpjValidator cpfCnpjValidator; // Validador adicionado
    private final EmailValidator emailValidator;

    public CreatePessoaUseCaseImp(PessoaGateway pessoaGateway, CpfCnpjValidator cpfCnpjValidator, EmailValidator emailValidator) {
        this.pessoaGateway = pessoaGateway;
        this.cpfCnpjValidator = cpfCnpjValidator; // Inicialização do validador
        this.emailValidator = emailValidator;
    }

    @Override
    public Pessoa execute(Pessoa pessoa) {
        if (pessoa.cpfCnpj() == null || pessoa.cpfCnpj().trim().isEmpty()) {
            throw new BusinessException("CPF/CNPJ não pode ser vazio.");
        }
        if (!cpfCnpjValidator.isCpfCnpjValid(pessoa.cpfCnpj())) {
            throw new BusinessException("CPF/CNPJ inválido: " + pessoa.cpfCnpj());
        }
        if (pessoa.email() == null || pessoa.email().trim().isEmpty()){
            throw new EmailError("Email não pode ser vazio");
        }
        if (!emailValidator.isValid(pessoa.email(), null)){
            throw new EmailError("Email de formato inválido: " + pessoa.email());
        }
        if (pessoaGateway.existsByEmail(pessoa.email())) {
            throw new EmailError("Já existe uma pessoa com o e-mail " + pessoa.email() + " cadastrada!");
        }
        Pessoa pessoaExistente = pessoaGateway.findByCpfCnpj(pessoa.cpfCnpj());
        if (pessoaExistente != null) {
            throw new BusinessException("Já existe uma pessoa com CPF/CNPJ " + pessoa.cpfCnpj() + " cadastrada!");
        }
        return pessoaGateway.createPessoa(pessoa);
    }
}
