package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipamentoServico {

    private EquipamentoRepositorio equipamentoRepositorio;
    private ClienteRepositorio repositorio;

    public Equipamento cadastrarEquipamento(Equipamento novoEquipamento){
        return null;
    }

    public List<Equipamento> buscarTodos(){
        return null;
    }

    public Equipamento buscarId(Integer id){
        return null;
    }

    public void deletar(Integer id){
    }

    public void atualizar(){

    }
}
