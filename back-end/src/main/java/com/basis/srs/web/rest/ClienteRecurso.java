package com.basis.srs.web.rest;

import com.basis.srs.servico.dto.ClienteDTO;
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
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClienteRecurso {

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(new ClienteDTO());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException{
        ClienteDTO dto = new ClienteDTO();
        return ResponseEntity.created(new URI("/a/i/clientes/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO dto = new ClienteDTO();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id){
        return ResponseEntity.ok().build();
    }

}
