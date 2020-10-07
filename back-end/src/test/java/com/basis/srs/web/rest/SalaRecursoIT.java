package com.basis.srs.web.rest;

import com.basis.srs.builder.SalaBuilder;
import com.basis.srs.dominio.Sala;
import com.basis.srs.servico.SalaServico;
import com.basis.srs.servico.mapper.SalaMapper;
import com.basis.srs.util.IntTestComum;
import com.basis.srs.util.TestUtil;
import lombok.RequiredArgsConstructor;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
@RequiredArgsConstructor
public class SalaRecursoIT extends IntTestComum {

    private final SalaBuilder salaBuilder;

    private final SalaServico salaServico;

    private final SalaMapper salaMapper;

    @BeforeEach
    public void deletarTodos(){
        salaBuilder.deletarTodos();
    }

    @Test
    public void listar() throws Exception{
        salaBuilder.construir();
        getMockMvc().perform(MockMvcRequestBuilders.get("/api/salas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", Matchers.hasSize(1)));
    }

    @Test
    public void salvar() throws Exception{
        Sala sala = salaBuilder.construirEntidade();
        getMockMvc().perform(MockMvcRequestBuilders.post("/api/salas")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(salaBuilder.converterToDTo(sala))
        ))
        .andExpect(status().isCreated());
    }

    @Test
    public void buscar() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(MockMvcRequestBuilders.get("api/salas/" + sala.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sala.getId()));
    }

    @Test
    public void editar() throws Exception{
        Sala sala = salaBuilder.construir();

        getMockMvc().perform(MockMvcRequestBuilders.put("api/salas")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(salaBuilder.converterToDTo(sala))
        ))
        .andExpect(status().isOk());
    }

    @Test
    public void deletar() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(MockMvcRequestBuilders.delete("/api/salas/" + sala.getId()))
                .andExpect(status().isOk());
    }
}
