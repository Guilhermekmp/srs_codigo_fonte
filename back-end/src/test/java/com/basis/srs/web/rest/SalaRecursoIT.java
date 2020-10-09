package com.basis.srs.web.rest;

import com.basis.srs.builder.ReservaBuilder;
import com.basis.srs.builder.SalaBuilder;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.dominio.Sala;
import com.basis.srs.servico.SalaServico;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.mapper.ReservaMapper;
import com.basis.srs.util.IntTestComum;
import com.basis.srs.util.TestUtil;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
public class SalaRecursoIT extends IntTestComum {

    @Autowired
    private SalaBuilder salaBuilder;

    @Autowired
    private ReservaBuilder reservaBuilder;

    @Autowired
    private ReservaMapper reservaMapper;

    @Autowired
    private SalaServico salaServico;

    @BeforeEach
    public void deletarTodos(){
        salaBuilder.deletarTodos();
    }

    @Test
    public void listar() throws Exception{
        salaBuilder.construir();
        getMockMvc().perform(get("/api/salas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", Matchers.hasSize(1)));
    }

    @Test
    public void salvar() throws Exception{
        Sala sala = salaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/salas")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(salaBuilder.converterToDTo(sala))
        ))
        .andExpect(status().isCreated());
    }

    @Test
    public void buscar() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(get("/api/salas/" + sala.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(sala.getId()));
    }

    @Test
    public void editar() throws Exception{
        Sala sala = salaBuilder.construirEntidade();

        getMockMvc().perform(put("/api/salas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(
                        salaBuilder.converterToDTo(sala))
                ))
                .andExpect(status().isOk());
    }

    @Test
    public void deletar() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(delete("/api/salas/" + sala.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void buscarIdInexistente() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(get("/api/salas/1721564"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deletarSalaInexistente() throws Exception{
        Sala sala = salaBuilder.construir();
        getMockMvc().perform(delete("/api/salas/123123" ))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deletarSalaReservada() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        ReservaDTO dto = reservaMapper.toDto(reserva);
        getMockMvc().perform(delete("/api/salas/" + dto.getIdSala()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void ehReservada() throws Exception{
     Reserva reserva = reservaBuilder.construir();
     boolean valor = false;
     valor = salaServico.ehReservada(reserva.getSala().getId());
        Assert.assertTrue(valor);
    }

    @Test
    public void criarSalasIguais() throws Exception{
        Sala sala = salaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/salas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(salaBuilder.converterToDTo(sala))
                ));
        getMockMvc().perform(post("/api/salas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(salaBuilder.converterToDTo(sala))
                ))
                .andExpect(status().isBadRequest());
    }



}
