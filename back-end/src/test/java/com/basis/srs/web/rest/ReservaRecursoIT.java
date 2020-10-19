package com.basis.srs.web.rest;


import com.basis.srs.builder.ReservaBuilder;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.util.IntTestComum;
import com.basis.srs.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Transactional
public class ReservaRecursoIT extends IntTestComum {

    @Autowired
    private ReservaBuilder reservaBuilder;

    @BeforeEach
    public void limparEntidade(){
        reservaBuilder.limpar();
    }

    @Test
    public void listar() throws Exception{
        reservaBuilder.construir();
        getMockMvc().perform(get("/api/reservas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", hasSize(1)));
    }

    @Test
    public void editar() throws Exception{
        Reserva reserva = reservaBuilder.construir();

        getMockMvc().perform(put("/api/reservas")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(
                reservaBuilder.converterToDto(reserva))
        ))
        .andExpect(status().isOk());

    }

    @Test
    public void erroEditar() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        reserva.setId(reserva.getId()+1);
        getMockMvc().perform(put("/api/reservas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(
                        reservaBuilder.converterToDto(reserva))
                ))
                .andExpect(status().isNotFound());

    }

    @Test
    public void salvar() throws Exception{
        Reserva reserva = reservaBuilder.construirEntidade();
        getMockMvc().perform(post("/api/reservas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reservaBuilder.converterToDto(reserva))
            ))
            .andExpect(status().isCreated());
    }

    @Test
    public void erroSalvarDtIni() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        Reserva reserva2 = reservaBuilder.construirEntidadeDtIni(reserva);
        getMockMvc().perform(post("/api/reservas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(reservaBuilder.converterToDto(reserva2))
                ))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void erroSalvarDtFim() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        Reserva reserva2 = reservaBuilder.construirEntidadeDtFim(reserva);
        getMockMvc().perform(post("/api/reservas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(reservaBuilder.converterToDto(reserva2))
                ))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void erroSalvarDtIniEntre() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        Reserva reserva2 = reservaBuilder.construirEntidadeDtIniEntre(reserva);
        getMockMvc().perform(post("/api/reservas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(reservaBuilder.converterToDto(reserva2))
                ))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void erroSalvarReservaEquipamento() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        Reserva reserva2 = reservaBuilder.construirEntidadeEquipamento(reserva);
        getMockMvc().perform(post("/api/reservas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(reservaBuilder.converterToDto(reserva2))
                ))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void obterPorId() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        getMockMvc().perform(get("/api/reservas/" + reserva.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(reserva.getId()));
    }

    @Test
    public void erroObterPorId() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        getMockMvc().perform(get("/api/reservas/" + reserva.getId() + 1))
                .andExpect(status().isNotFound());
    }

    @Test
    public void apagar() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        getMockMvc().perform(delete("/api/reservas/" + reserva.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void erroApagar() throws Exception{
        Reserva reserva = reservaBuilder.construir();
        getMockMvc().perform(delete("/api/reservas/" + 5))
                .andExpect(status().isNotFound());
    }

}
