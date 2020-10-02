package com.basis.srs.web.rest;



import com.basis.srs.servico.TipoEquipamentoServico;
import lombok.RequiredArgsConstructor;
import com.basis.srs.dominio.TipoEquipamento;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-equipamento")
@RequiredArgsConstructor
public class TipoEquipamentoRecurso {
    private TipoEquipamentoServico tipo_equipamentoServico;

    @GetMapping
    public List<TipoEquipamento> obter(){
        return null;
    }

    @GetMapping(path = "/{id}")
    public TipoEquipamento obterPorId(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public TipoEquipamento cadastrar(@RequestBody TipoEquipamento tipo_equipamento){
        return null;
    }

    @PutMapping
    public TipoEquipamento atualizar(@RequestBody TipoEquipamento tipo_equipamento){
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public TipoEquipamento deletar(@PathVariable Integer id){
        return null;
    }
}
