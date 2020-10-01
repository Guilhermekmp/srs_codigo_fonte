package com.basis.srs.servicos;

import com.basis.srs.repositorio.Tipo_equipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class Tipo_equipamentoServico {

    private final Tipo_equipamentoRepositorio tipo_equipamentoRepositorio;

    public Tipo_equipamentoServico(Tipo_equipamentoRepositorio tipo_equipamentoRepositorio) {
        this.tipo_equipamentoRepositorio = tipo_equipamentoRepositorio;
    }
}
