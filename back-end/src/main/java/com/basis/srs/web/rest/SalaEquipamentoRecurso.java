package com.basis.srs.web.rest;

import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.servico.SalaEquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api/sala-equipamento") @RequiredArgsConstructor
public class SalaEquipamentoRecurso {

   private SalaEquipamentoServico salaEquipamentoServico;

    //GET todos
    @GetMapping
    public List<SalaEquipamento> listar(){
        return null;
    }

    //GET por id
    @GetMapping(path = "/{id}")
    public SalaEquipamento buscar(@PathVariable int id){
        return null;
    }

    //POST
    @PostMapping
    public SalaEquipamento criar(@RequestBody SalaEquipamento salaEquipamento){
        return null;
    }

    //PUT
    @PutMapping
    public SalaEquipamento atualizar(@RequestBody SalaEquipamento salaEquipamento){
        return null;
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public SalaEquipamento deletar(@PathVariable int id){
        return null;
    }

}
