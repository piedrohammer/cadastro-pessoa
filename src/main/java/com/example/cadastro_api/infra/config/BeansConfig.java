package com.example.cadastro_api.infra.config;

import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.core.usecases.*;
import com.example.cadastro_api.core.validators.CpfCnpjValidator; // Importar o validador
import com.example.cadastro_api.core.validators.EmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway, CpfCnpjValidator cpfCnpjValidator, EmailValidator emailValidator) {
        return new CreatePessoaUseCaseImp(pessoaGateway, cpfCnpjValidator, emailValidator);
    }

    @Bean
    public GetAllPessoasUseCase getAllPessoasUseCase(PessoaGateway pessoaGateway) {
        return new GetAllPessoasUseCaseImp(pessoaGateway);
    }

    @Bean
    public FindByCpfPessoaUseCase findByCpfPessoaUseCase(PessoaGateway pessoaGateway){
        return new FindByCpfPessoaUseCaseImp(pessoaGateway);
    }

    @Bean
    public DeletePessoaUseCase deletePessoaUseCase(PessoaGateway pessoaGateway){
        return new DeletePessoaUseCaseImp(pessoaGateway);
    }

    @Bean
    public UpdatePessoaEmailUseCase updatePessoaEmailUseCase(PessoaGateway pessoaGateway){
        return new UpdatePessoaEmailUseCaseImp(pessoaGateway);
    }

    @Bean
    public CpfCnpjValidator cpfCnpjValidator() {
        return new CpfCnpjValidator(); // Cria e retorna uma nova instância do validador
    }

    @Bean
    public EmailValidator emailValidator(){
        return new EmailValidator();
    }
}
