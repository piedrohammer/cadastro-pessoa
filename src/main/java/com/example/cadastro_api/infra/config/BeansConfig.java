package com.example.cadastro_api.infra.config;

import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.core.usecases.CreatePessoaUseCase;
import com.example.cadastro_api.core.usecases.CreatePessoaUseCaseImp;
import com.example.cadastro_api.core.usecases.GetAllPessoasUseCase;
import com.example.cadastro_api.core.usecases.GetAllPessoasUseCaseImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreatePessoaUseCase createPessoaUseCase(PessoaGateway pessoaGateway) {
        return new CreatePessoaUseCaseImp(pessoaGateway);
    }

    @Bean
    public GetAllPessoasUseCase getAllPessoasUseCase(PessoaGateway pessoaGateway) {
        return new GetAllPessoasUseCaseImp(pessoaGateway);
    }
}
