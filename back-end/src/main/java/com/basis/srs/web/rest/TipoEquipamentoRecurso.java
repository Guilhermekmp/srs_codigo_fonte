package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.TipoEquipamento;
import com.basis.srs.servico.EquipamentoServico;
import com.basis.srs.servico.TipoEquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    private TipoEquipamentoServico tipoEquipamentoServico;

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
