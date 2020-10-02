package com.basis.srs.web.rest;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.servico.ReservaServico;
import com.basis.srs.servico.dto.ReservaDTO;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/reserva")
@RequiredArgsConstructor
public class ReservaRecurso {
    private final ReservaServico reservaServico;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar(){
        return ResponseEntity.ok(reservaServico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> obterPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(reservaServico.procurar(id));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@RequestBody ReservaDTO reservaDTO) throws URISyntaxException {
        ReservaDTO dto = reservaServico.salvar(reservaDTO);
        return ResponseEntity.created(new URI("/a/i/Reservas/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ReservaDTO> atualizar(@RequestBody ReservaDTO reservaDTO){
        ReservaDTO dto = reservaServico.salvar(reservaDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id){
        reservaServico.deletar(id);
        return ResponseEntity.ok().build();
    }
}
