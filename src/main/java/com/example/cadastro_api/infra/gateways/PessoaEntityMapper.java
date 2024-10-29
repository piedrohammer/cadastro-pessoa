package com.example.cadastro_api.infra.gateways;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.infra.persistence.entities.PessoaEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaEntityMapper {

    public PessoaEntity toEntity(Pessoa pessoa) {
        return new PessoaEntity(pessoa.id(), pessoa.nome(), pessoa.email(), pessoa.cpfCnpj(), pessoa.type());
    }

    public Pessoa toPessoa(PessoaEntity entity) {
        return new Pessoa(entity.getId(), entity.getNome(), entity.getEmail(), entity.getCpfCnpj(), entity.getType());
    }
}

