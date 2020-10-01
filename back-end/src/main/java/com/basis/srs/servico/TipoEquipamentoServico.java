package com.basis.srs.servico;

import com.basis.srs.repositorio.TipoEquipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoEquipamentoServico {

    private TipoEquipamentoRepositorio tipo_equipamentoRepositorio;
}
