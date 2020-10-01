package com.basis.srs.web.rest;

import com.basis.srs.servico.ClienteServico;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Getter
@Setter
public class ClienteRecurso {

    private ClienteServico servico;

    public void inserirCliente(){
    }
    public void listarClientes(){
    }
    public void listarClienteId(){
    }
    public void atualizar(){
    }
    public void deletar(){
    }


}
