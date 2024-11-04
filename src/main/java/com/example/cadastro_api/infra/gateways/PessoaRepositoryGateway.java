package com.example.cadastro_api.infra.gateways;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.gateways.PessoaGateway;
import com.example.cadastro_api.infra.persistence.entities.PessoaEntity;
import com.example.cadastro_api.infra.persistence.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryGateway implements PessoaGateway {

    // Classe para chamar os metodos no Repository

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

    @Override
    @Transactional
    //transação ativa para a operação de remoção, que geralmente é necessária ao tentar excluir uma entidade. Para resolver isso, você precisa garantir que o método de exclusão seja executado dentro de uma transação.
    //Solução: Adicionar Anotação @Transactional
    //A anotação @Transactional no método de exclusão garante que ele seja executado em uma transação. Você pode adicioná-la na implementação do caso de uso de exclusão ou no método deleteByCpfCnpj do PessoaRepositoryGateway.
    public void deleteByCpfCnpj(String cpfCnpj) {
        pessoaRepository.deleteByCpfCnpj(cpfCnpj);
    }

    @Override
    @Transactional
    public Pessoa updatePessoa(Pessoa pessoa) {
        PessoaEntity entity = entityMapper.toEntity(pessoa);
        PessoaEntity updatedEntity = pessoaRepository.save(entity); // Salva a entidade com o novo email
        return entityMapper.toPessoa(updatedEntity);
    }

    @Override
    public boolean existsByEmail(String email) {
        return pessoaRepository.existsByEmail(email);
    }
}
