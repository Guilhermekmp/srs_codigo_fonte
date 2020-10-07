package com.basis.srs.builder;

import com.basis.srs.dominio.Cliente;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class ClienteBuilder extends ConstrutorDeEntidade<Cliente>{

    @Override
    public Cliente construirEntidade() throws ParseException {
        return null;
    }

    @Override
    public Cliente persistir(Cliente entidade) {
        return null;
    }

    @Override
    public Collection<Cliente> obterTodos() {
        return null;
    }

    @Override
    public Cliente obterPorId(Long id) {
        return null;
    }
}
