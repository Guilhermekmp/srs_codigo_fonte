package com.basis.srs.web.rest;

import com.basis.srs.servico.ClienteServico;
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

    private final ClienteServico clienteServico;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(clienteServico.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> listar(@PathVariable("{id}") Integer id){
        return ResponseEntity.ok(clienteServico.listarId(id));
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException{
        return null;
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO clienteDTO){
        return null;
=======
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.created(new URI("/api/clientes/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editar(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.ok(dto);
>>>>>>> origin/develop
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("{id}") Integer id){
        clienteServico.deletar(id);
        return ResponseEntity.ok().build();
    }


}
