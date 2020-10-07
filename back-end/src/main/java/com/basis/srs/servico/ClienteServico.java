package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<ClienteDTO> lista = clienteMapper.toDto(clienteRepositorio.findAll());
        return lista;
    }

    public ClienteDTO listarId(Integer id){
        ClienteDTO cliente = clienteMapper.toDto(clienteRepositorio.findById(id).orElse(null));
        return cliente;
    }

    public void deletar(Integer id){
        clienteRepositorio.deleteById(id);
    }
}
