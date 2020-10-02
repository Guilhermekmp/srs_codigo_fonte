package com.basis.srs.web.rest;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.servico.ReservaServico;
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
@RequestMapping(path="/api/reserva")
@RequiredArgsConstructor
public class ReservaRecurso {

    private ReservaServico servico;

    @GetMapping
    public ResponseEntity<List<Reserva>> listar(){
        return null;
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Reserva> procurar(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva){
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Reserva> excluir(@PathVariable Integer id){
        return null;
    }

    @PutMapping
    public ResponseEntity<Reserva> alterar(@RequestBody Reserva reserva){
        return null;
    }

}
