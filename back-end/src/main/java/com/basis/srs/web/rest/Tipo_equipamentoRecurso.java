package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Tipo_equipamento;
import com.basis.srs.servicos.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class Tipo_equipamentoRecurso {
    private EquipamentoServico equipamentoServico;

    @GetMapping
    public List<Tipo_equipamento> obter(){
        return null;
    }
    @GetMapping("/{id}")
    public Tipo_equipamento obterPorId(@PathVariable int id){
        return null;
    }
    @PostMapping
    public Equipamento cadastrar(@RequestBody Tipo_equipamento tipo_equipamento){
        return null;
    }
    @PutMapping
    public Equipamento atualizar(@RequestBody Tipo_equipamento tipo_equipamento){
        return null;
    }
    @DeleteMapping
    public Equipamento deletar(){
        return null;
    }
}
