package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.servico.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/equipamentos")
@RequiredArgsConstructor
public class EquipamentoRecurso {

    private EquipamentoServico servicoUsuario;

    @GetMapping
    public ResponseEntity<List<Equipamento>> obter(){
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Equipamento> obterPorId(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Equipamento> cadastro(@RequestBody Equipamento newEquipamento){
        return null;
    }

    @PutMapping
    public ResponseEntity<Equipamento> atualizar(@RequestBody Equipamento newEquipamento){
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Equipamento> deletar(@PathVariable Integer id){
        return null;
    }
}
