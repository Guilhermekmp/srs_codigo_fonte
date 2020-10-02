package com.basis.srs.web.rest;

import com.basis.srs.servico.ClienteServico;
<<<<<<< HEAD

=======
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
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

<<<<<<< HEAD
    private ClienteServico clienteServico;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar(){
        return ResponseEntity.ok(new ArrayList<>());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> listar(@PathVariable("{id}") Integer id){
=======
    private final ClienteServico clienteServico;
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar(){

        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterPorId(@PathVariable("id") Integer id){
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
        return ResponseEntity.ok(new ClienteDTO());
    }

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        ClienteDTO dto = new ClienteDTO();
        return ResponseEntity.created(new URI(s:"/api/clientes/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> editar(){
        ClienteDTO dto = new ClienteDTO();
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("{id}") Integer id){
        return ResponseEntity.ok().build();
=======
    public ResponseEntity<ClienteDTO> salvar(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException{
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.created(new URI("/a/i/clientes/")).body(dto);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> atualizar(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO dto = clienteServico.salvar(clienteDTO);
        return ResponseEntity.ok(dto);
>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable("id") Integer id){
        clienteServico.deletar(id);
        return ResponseEntity.ok().build();
    }

}
