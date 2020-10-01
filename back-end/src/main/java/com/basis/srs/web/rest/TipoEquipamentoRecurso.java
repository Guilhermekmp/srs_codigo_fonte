package com.basis.srs.web.rest;

import com.basis.srs.dominio.TipoEquipamento;
import com.basis.srs.servico.TipoEquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-equipamentos")
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
    public ResponseEntity<TipoEquipamento> deletar(@PathVariable Integer id){
        return null;
    }
}
