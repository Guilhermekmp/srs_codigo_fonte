package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.mapper.ClienteMapper;
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

    private final ClienteRepositorio clienteRepositorio;
    private final ClienteMapper clienteMapper;

    public ClienteDTO salvar(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        ClienteDTO salvar = clienteMapper.toDto(clienteRepositorio.save(cliente));
        return salvar;
    }

    public List<ClienteDTO> listar(){
<<<<<<< HEAD
        return null;
    }
    
    public ClienteDTO obterPorId(Integer id){
        return new ClienteDTO();
=======
        List<ClienteDTO> lista = clienteMapper.toDto(clienteRepositorio.findAll());
        return lista;
>>>>>>> origin/develop
    }

    public ClienteDTO listarId(Integer id){
        ClienteDTO cliente = clienteMapper.toDto(clienteRepositorio.findById(id).orElse(null));
        return cliente;
    }

    public void deletar(Integer id){
        clienteRepositorio.deleteById(id);
    }

}
