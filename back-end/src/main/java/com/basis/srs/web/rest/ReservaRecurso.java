package com.basis.srs.web.rest;

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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path="/api/reservas")
@RequiredArgsConstructor
public class ReservaRecurso {

    private final ReservaServico reservaServico;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar(){
        return ResponseEntity.ok(reservaServico.listar());
    }

    @PostMapping("/total")
    public ResponseEntity<ReservaDTO> getTotal(@RequestBody ReservaDTO dto){
        return ResponseEntity.ok(reservaServico.custoTotal(dto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> listar(@PathVariable Integer id){
        return ResponseEntity.ok(reservaServico.buscar(id));
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> salvar(@Valid @RequestBody ReservaDTO reservaDTO) throws URISyntaxException {
        ReservaDTO dto = reservaServico.criar(reservaDTO);
        return ResponseEntity.created(new URI("/api/reservas/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ReservaDTO> editar(@Valid @RequestBody ReservaDTO reservaDTO){
        ReservaDTO dto = reservaServico.criar(reservaDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        reservaServico.deletar(id);
        return ResponseEntity.ok().build();
    }

}
