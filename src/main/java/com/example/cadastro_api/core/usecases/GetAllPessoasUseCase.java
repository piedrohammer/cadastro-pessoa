package com.example.cadastro_api.core.usecases;

import com.example.cadastro_api.core.entities.Pessoa;
import java.util.List;

public interface GetAllPessoasUseCase {

    public List<Pessoa> execute();
}
