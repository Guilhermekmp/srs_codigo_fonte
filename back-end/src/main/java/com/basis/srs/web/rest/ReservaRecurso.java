package com.basis.srs.web.rest;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.ReservaServico;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/reserva")
@Getter @Setter
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
