package com.basis.srs.web.rest;

import com.basis.srs.servico.EquipamentoServico;
import com.basis.srs.servico.dto.EquipamentoDTO;
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
@RequestMapping("/api/equipamentos")
@RequiredArgsConstructor
public class EquipamentoRecurso {
    private final EquipamentoServico equipamentoServico;

    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> listar(){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipamentoDTO> obterPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(new EquipamentoDTO());
    }

    @PostMapping
    public ResponseEntity<EquipamentoDTO> salvar(@RequestBody EquipamentoDTO EquipamentoDTO) throws URISyntaxException {
        EquipamentoDTO dto = new EquipamentoDTO();
        return ResponseEntity.created(new URI("/a/i/Equipamentos/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<EquipamentoDTO> atualizar(@RequestBody EquipamentoDTO EquipamentoDTO){
        EquipamentoDTO dto = new EquipamentoDTO();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id){
        return ResponseEntity.ok().build();
    }
}
