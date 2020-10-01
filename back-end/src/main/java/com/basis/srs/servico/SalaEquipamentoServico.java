package com.basis.srs.servico;

import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.SalaEquipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @RequiredArgsConstructor @Transactional
public class SalaEquipamentoServico {

    private SalaEquipamentoRepositorio salaEquipamentoRepositorio;

    public void listar(){
        return;
    }

    public void buscar(Integer id){
        return;
    }

    public void criar(SalaEquipamento salaEquipamento){
        return;
    }

    public void alterar(SalaEquipamento salaEquipamento){
        return;
    }

    public void deletar(Integer id){
        return;
    }
}
