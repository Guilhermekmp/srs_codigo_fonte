package com.basis.srs.web.rest;

import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.SalaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/api/salas") @RequiredArgsConstructor
public class SalaRecurso {

    private SalaRepositorio salaRepositorio;

    //GET todos
    @GetMapping
    public List<SalaEquipamento> listar(){
        return null;
    }

    //GET por id
    @GetMapping(path = "/{id}")
    public SalaEquipamento buscar(@PathVariable Integer id){
        return null;
    }

    //POST
    @PostMapping
    public SalaEquipamento criar(@RequestBody Sala sala){
        return null;
    }

    //PUT
    @PutMapping
    public SalaEquipamento atualizar(@RequestBody Sala sala){
        return null;
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public SalaEquipamento deletar(@PathVariable Integer id){
        return null;
    }


}
