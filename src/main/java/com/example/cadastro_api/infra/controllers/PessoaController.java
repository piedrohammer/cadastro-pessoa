package com.example.cadastro_api.infra.controllers;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.usecases.*;
import com.example.cadastro_api.infra.dtos.PessoaDto;
import com.example.cadastro_api.infra.dtos.PessoaDtoMapper;
import com.example.cadastro_api.infra.dtos.UpdateEmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final GetAllPessoasUseCase getAllPessoasUseCase;
    private final FindByCpfPessoaUseCase findByCpfPessoaUseCase;
    private final DeletePessoaUseCase deletePessoaUseCase;
    private final UpdatePessoaEmailUseCase updatePessoaEmailUseCase;
    private final PessoaDtoMapper pessoaDtoMapper;

    @PostMapping
    public PessoaDto createPessoa(@Valid @RequestBody PessoaDto pessoaDto) {
        Pessoa novoPessoa = createPessoaUseCase.execute(pessoaDtoMapper.toEntity(pessoaDto));
        return pessoaDtoMapper.toDto(novoPessoa);
    }

    @GetMapping
    public List<PessoaDto> obtainAll() {
        return getAllPessoasUseCase.execute()
                .stream().map(pessoaDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{cpfCnpj}")
    public PessoaDto findPessoaByCpf(@PathVariable String cpfCnpj) {
        Pessoa pessoa = findByCpfPessoaUseCase.execute(cpfCnpj);
        return pessoaDtoMapper.toDto(pessoa);
    }

    @DeleteMapping("/{cpfCnpj}")
    public void deletePessoaByCpf(@PathVariable String cpfCnpj) {
        deletePessoaUseCase.deleteByCpfCnpj(cpfCnpj);
    }

    @PutMapping("/{cpfCnpj}/email")
    public PessoaDto updateEmail(@PathVariable String cpfCnpj, @RequestBody UpdateEmailRequest request) {
        Pessoa pessoaAtualizada = updatePessoaEmailUseCase.execute(cpfCnpj, request.getNovoEmail());
        return pessoaDtoMapper.toDto(pessoaAtualizada);
    }
}

