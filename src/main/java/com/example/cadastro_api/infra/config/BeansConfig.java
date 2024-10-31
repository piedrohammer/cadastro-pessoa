package com.example.cadastro_api.infra.config;

import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    // Estou "Transferindo" de core para infra


    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway) {
        return new CreatePessoaUseCaseImp(pessoaGateway);
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
}
