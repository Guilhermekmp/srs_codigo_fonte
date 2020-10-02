package com.basis.srs.servico;

import com.basis.srs.dominio.Sala;
import com.basis.srs.repositorio.SalaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SalaServico {

    private SalaRepositorio salaRepositorio;

    public void listar(){
        return;
    }

    public void buscar(Integer id){
        return;
    }

    public void criar(Sala sala){
        return;
    }

    public void alterar(Sala sala){
        return;
    }

    public void deletar(Integer id){
        return;
    }
}
