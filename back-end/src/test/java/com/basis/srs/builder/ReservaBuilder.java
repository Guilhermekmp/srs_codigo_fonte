package com.basis.srs.builder;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.servico.ReservaServico;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.mapper.ReservaMapper;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservaBuilder extends ConstrutorDeEntidade<Reserva>{

    private final ReservaServico reservaServico;
    private final ReservaMapper reservaMapper;
    private final ReservaRepositorio reservaRepositorio;

    private final ClienteBuilder clienteBuilder;
    private final SalaBuilder salaBuilder;

    @Override
    public Reserva construirEntidade() throws ParseException {
        Reserva reserva = new Reserva();
        reserva.setCliente(clienteBuilder.construir());
        reserva.setSala(salaBuilder.construir());
        reserva.setDataInicio(LocalDateTime.now());
        reserva.setDataFim(LocalDateTime.of(2021-10-12,10,00,00,000));
        reserva.setTotal(200.00);

        return reserva;
    }

    @Override
    public Reserva persistir(Reserva entidade) {
        ReservaDTO dto = reservaServico.criar(reservaMapper.toDto(entidade));
        return reservaMapper.toEntity(dto);
    }

    @Override
    public Collection<Reserva> obterTodos() {
        return null;
    }

    @Override
    public Reserva obterPorId(Long id) {
        return null;
    }

    public void limpar(){
        reservaRepositorio.deleteAll();
    }

    public ReservaDTO converterToDto(Reserva reserva){
        return reservaMapper.toDto(reserva);
    }
}
