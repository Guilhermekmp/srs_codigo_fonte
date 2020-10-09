package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ClienteRepositorio;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.dto.ClienteDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
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
    private final ReservaRepositorio reservaRepositorio;

    public ClienteDTO salvar(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        for (Cliente user : clienteRepositorio.findAll()){
            if(user.getCpf().equals(cliente.getCpf()) || user.getRg().equals(cliente.getRg())){
                throw new RegraNegocioException("Cpf ou rg iguais");
            }
        }
        ClienteDTO salvar = clienteMapper.toDto(clienteRepositorio.save(cliente));
        return salvar;
    }

    public List<ClienteDTO> listar(){
        List<ClienteDTO> lista = clienteMapper.toDto(clienteRepositorio.findAll());
        return lista;
    }

    public ClienteDTO listarId(Integer id){
        Cliente cliente = clienteRepositorio.findById(id)
        .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado"));
        ClienteDTO clienteDto = clienteMapper.toDto(cliente);
        return clienteDto;
    }

    public void deletar(Integer id) {
        Cliente cliente = clienteMapper.toEntity(listarId(id));
        for (Reserva reserva: reservaRepositorio.findAll()) {
            if(reserva.getCliente().equals(cliente)){
                throw new RegraNegocioException("Cliente possui uma reserva ou não existe");
             }
        }
        clienteRepositorio.deleteById(id);
    }



}
