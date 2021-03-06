package com.basis.srs.web.rest;

import com.basis.srs.builder.ClienteBuilder;
import com.basis.srs.dominio.Cliente;
import com.basis.srs.util.IntTestComum;
import com.basis.srs.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
public class ClienteRecursoIT extends IntTestComum {

    @Autowired
    private ClienteBuilder clienteBuilder;

    @BeforeEach
    public void limparBanco(){
        clienteBuilder.limparBanco();
    }

    @Test
    public void salvar() throws Exception {
        Cliente cliente = clienteBuilder.construirEntidade();
        getMockMvc().perform(post("/api/clientes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(
                        clienteBuilder.converterToDto(cliente))
                ))
                .andExpect(status().isCreated());
    }

    @Test
    public void editar() throws Exception {
        Cliente cliente = clienteBuilder.construir();
        getMockMvc().perform(put("/api/clientes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(
                        clienteBuilder.converterToDto(cliente))
                ))
                .andExpect(status().isOk());
    }

    @Test
    public void buscar() throws Exception {
        Cliente cliente = clienteBuilder.construir();
        getMockMvc().perform(get("/api/clientes/" + cliente.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cliente.getId()));
    }

    @Test
    public void listar() throws Exception {
        clienteBuilder.construir();
        getMockMvc().perform(get("/api/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", Matchers.hasSize(1)));
    }

    @Test
    public void deletar() throws Exception {
        Cliente cliente = clienteBuilder.construir();
        getMockMvc().perform(delete("/api/clientes/" + cliente.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void erroSalvarExistente() throws Exception {
        Cliente cliente = clienteBuilder.construir();
        Cliente cliente1 = clienteBuilder.construirEntidade();
        getMockMvc().perform(post("/api/clientes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(
                        clienteBuilder.converterToDto(cliente1)))).andExpect(status().isBadRequest());
    }

    @Test
    public void erroApagarExistente() throws Exception{
        Cliente cliente = clienteBuilder.construirEntidade();
        getMockMvc().perform(delete("/api/clientes/" + cliente.getId()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void erroApagarInexistente() throws Exception {
        Cliente cliente = clienteBuilder.construirEntidade();
        getMockMvc().perform(delete("/api/clientes/" + 500))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void erroEditar() throws Exception {
        Cliente cliente = clienteBuilder.construir();
        Cliente cliente1 = cliente;
        cliente1.setId(cliente.getId() + 1);
        getMockMvc().perform(put("/api/clientes")
                .contentType(TestUtil.APPLICATION_JSON_UTF8).content(TestUtil.convertObjectToJsonBytes(
                        clienteBuilder.converterToDto(cliente1)))).andExpect(status().isBadRequest());

    }


}

