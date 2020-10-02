package com.basis.srs.web.rest;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.servico.ClienteServico;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Getter
@Setter
@RequestMapping(path ="/api/clientes")
public class ClienteRecurso {

    private ClienteServico servico;

    @PostMapping
    public ResponseEntity<Integer> criar(@RequestBody Cliente cliente){
        return null;
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        return null;
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<Cliente> procurar(@PathVariable Integer id){
        return null;
    }

    @PutMapping
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
        return null;
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        return null;
    }


}
