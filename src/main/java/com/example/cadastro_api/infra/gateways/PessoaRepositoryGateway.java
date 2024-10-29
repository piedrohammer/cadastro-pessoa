package com.example.cadastro_api.infra.gateways;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.infra.persistence.entities.PessoaEntity;
import com.example.cadastro_api.infra.persistence.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryGateway implements PessoaGateway {

    private final PessoaRepository pessoaRepository;
    private final PessoaEntityMapper entityMapper;

    @Override
    public Pessoa createPessoa(Pessoa pessoa) {
        PessoaEntity entity = entityMapper.toEntity(pessoa);
        PessoaEntity novaPessoa = pessoaRepository.save(entity);
        return entityMapper.toPessoa(novaPessoa);
    }

    @Override
    public Pessoa findByCpfCnpj(String cpfCnpj) {
        PessoaEntity entity = pessoaRepository.findByCpfCnpj(cpfCnpj);
        if (entity == null) {
            return null;
        }
        return entityMapper.toPessoa(entity);
    }

    @Override
    public List<Pessoa> obtainAllPessoas() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(entityMapper::toPessoa)
                .collect(Collectors.toList());
    }
}
