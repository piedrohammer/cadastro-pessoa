package com.example.cadastro_api.infra.dtos;

import com.example.cadastro_api.core.entities.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaDtoMapper {

    public PessoaDto toDto(Pessoa pessoa) {
        return new PessoaDto(pessoa.nome(), pessoa.email(), pessoa.cpfCnpj(), pessoa.type());
    }

    public Pessoa toEntity(PessoaDto pessoaDto) {
        return  new Pessoa(null, pessoaDto.nome(), pessoaDto.email(), pessoaDto.cpfCnpj(), pessoaDto.type());
    }
}