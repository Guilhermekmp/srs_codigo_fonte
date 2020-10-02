package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServico {

    private ClienteRepositorio clienteRepositorio;

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




}
