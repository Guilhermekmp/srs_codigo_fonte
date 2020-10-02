package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServico {

    private ClienteRepositorio clienteRepositorio;

<<<<<<< HEAD
    public List<ClienteDTO> listar(){
        return new ArrayList<>();
    }

    public ClienteDTO obterId(Integer id){
        return new ClienteDTO();
    }
=======
    public ClienteDTO salvar(Cliente novoCliente){
        return new ClienteDTO();
    }

    public List<ClienteDTO> listar(){

        return clienteRepositorio.findAll();
    }
    
    public ClienteDTO obterPorId(Integer id){
        return new ClienteDTO();
    }

    public void deletar(Integer id){
    }

    public void atualizar(ClienteDTO clienteDTO){

    }


>>>>>>> 2d3b7a30470c9e465dbcf43df90ba1023dc67875


}
