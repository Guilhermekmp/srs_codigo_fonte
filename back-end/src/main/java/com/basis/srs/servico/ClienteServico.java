package com.basis.srs.servico;

import com.basis.srs.dominio.Cliente;
import com.basis.srs.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor @Transactional
public class ClienteServico {

    private ClienteRepositorio repositorio;

    public Cliente inserirCliente(Cliente novoCliente){
        return null;
    }

    public List<Cliente> listarIds(){
        return null;
    }
    
    public Cliente listarId(Integer id){
        return null;
    }

    public void deletar(Integer id){
    }

    public void atualizar(){
    }




}
