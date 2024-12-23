package com.example.cadastro_api.infra.persistence.repositories;

import com.example.cadastro_api.infra.persistence.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    PessoaEntity findByCpfCnpj(String cpfCnpj);
    void deleteByCpfCnpj(String cpfCnpj);
    boolean existsByEmail(String email);
}
