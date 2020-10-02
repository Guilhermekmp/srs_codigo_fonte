package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.TipoEquipamento;
import com.basis.srs.servico.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
@RequiredArgsConstructor
public class Tipo_equipamentoRecurso {
    private EquipamentoServico equipamentoServico;

    @GetMapping
    public List<TipoEquipamento> obter(){
        return null;
    }
    @GetMapping("/{id}")
    public TipoEquipamento obterPorId(@PathVariable Integer id){
        return null;
    }
    @PostMapping
    public Equipamento cadastrar(@RequestBody TipoEquipamento tipo_equipamento){
        return null;
    }
    @PutMapping
    public ResponseEntity<TipoEquipamento> atualizar(@RequestBody TipoEquipamento tipo_equipamento){
        return null;
    }

}
