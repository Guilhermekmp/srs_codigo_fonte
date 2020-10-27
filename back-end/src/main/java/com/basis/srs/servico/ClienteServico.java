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
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServico {

    private final ClienteRepositorio clienteRepositorio;
    private final ClienteMapper clienteMapper;
    private final ReservaRepositorio reservaRepositorio;

    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        if(clienteDTO.getId() == null){
            validarDuplicidade(cliente.getCpf());
        }
        validarClientePorCPFeRG(cliente.getCpf(), cliente.getRg(), cliente);
        ClienteDTO retorno = clienteMapper.toDto(clienteRepositorio.save(cliente));
        return retorno;

    }
    private void validarDuplicidade(String cpf) {
        Integer existe;
        existe = clienteRepositorio.findByCpf(cpf);
        if(existe != 0){
            throw new RegraNegocioException("Cpf já cadastrado na base");
        }
    }

    private void validarClientePorCPFeRG(String cpf, String rg, Cliente cliente) {
        for (Cliente user : clienteRepositorio.findAll()) {
            if (Objects.nonNull(cliente.getId()) && cliente.getId() != user.getId() && (user.getCpf().equals(cpf) || user.getRg().equals(rg))) {
                throw new RegraNegocioException("Cpf ou rg iguais");
            }
        }
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
