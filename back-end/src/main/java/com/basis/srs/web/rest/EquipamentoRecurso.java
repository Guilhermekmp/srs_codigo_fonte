package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.servico.dto.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipamento> deletar(@PathVariable int id){
        return null;
    }
}
