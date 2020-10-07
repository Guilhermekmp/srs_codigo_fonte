package com.basis.srs.web.rest;

import com.basis.srs.servico.SalaServico;
import com.basis.srs.servico.dto.SalaDTO;
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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
public class SalaRecurso {

    private final SalaServico salaServico;

    @GetMapping
    public ResponseEntity<List<SalaDTO>> listar(){

        return ResponseEntity.ok(salaServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> obterPorId(@Valid @PathVariable Integer id){
        return ResponseEntity.ok(salaServico.buscar(id));
    }

    @PostMapping
    public ResponseEntity<SalaDTO> salvar(@Valid @RequestBody SalaDTO sala) throws URISyntaxException {
        SalaDTO dto = salaServico.criar(sala);
        return ResponseEntity.created(new URI("/a/i/Salas/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<SalaDTO> atualizar(@Valid @RequestBody SalaDTO sala){
        SalaDTO dto = salaServico.criar(sala);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@Valid @PathVariable Integer id){
        salaServico.deletar(id);
        return ResponseEntity.ok().build();
    }

}
