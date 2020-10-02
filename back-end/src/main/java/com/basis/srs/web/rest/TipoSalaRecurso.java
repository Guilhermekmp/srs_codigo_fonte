package com.basis.srs.web.rest;

import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.dominio.TipoSala;
import com.basis.srs.repositorio.TipoSalaRepositorio;
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
@RequestMapping("/api/tipos-sala") @RequiredArgsConstructor
public class TipoSalaRecurso {
    private TipoSalaRepositorio tipoSalaRepositorio;

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
    public SalaEquipamento criar(@RequestBody TipoSala tipoSala){
        return null;
    }

    //PUT
    @PutMapping
    public SalaEquipamento atualizar(@RequestBody TipoSala tipoSala){
        return null;
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public SalaEquipamento deletar(@PathVariable Integer id){
        return null;
    }


}
