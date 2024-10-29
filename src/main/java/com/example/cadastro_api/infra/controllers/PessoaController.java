package com.example.cadastro_api.infra.controllers;

import com.example.cadastro_api.core.entities.Pessoa;
import com.example.cadastro_api.core.usecases.CreatePessoaUseCase;
import com.example.cadastro_api.core.usecases.GetAllPessoasUseCase;
import com.example.cadastro_api.infra.dtos.PessoaDto;
import com.example.cadastro_api.infra.dtos.PessoaDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pessoas")
@AllArgsConstructor
public class PessoaController {

    private final CreatePessoaUseCase createPessoaUseCase;
    private final GetAllPessoasUseCase getAllPessoasUseCase;
    private final PessoaDtoMapper pessoaDtoMapper;

    @PostMapping
    public PessoaDto createPessoa(@RequestBody PessoaDto pessoaDto) {
        Pessoa novoPessoa = createPessoaUseCase.execute(pessoaDtoMapper.toEntity(pessoaDto));
        return pessoaDtoMapper.toDto(novoPessoa);
    }

    @GetMapping
    public List<PessoaDto> obtainAll() {
        return getAllPessoasUseCase.execute()
                .stream().map(pessoaDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
