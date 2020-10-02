package com.basis.srs.servico;

import com.basis.srs.dominio.TipoSala;
import com.basis.srs.repositorio.TipoSalaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TipoSalaServico {

    private TipoSalaRepositorio tipoSalaRepositorio;

    public void listar(){
        return;
    }

    public void buscar(Integer id){
        return;
    }

    public void criar(TipoSala tipoSala){
        return;
    }

    public void alterar(TipoSala tipoSala){
        return;
    }

    public void deletar(Integer id){
        return;
    }

}
