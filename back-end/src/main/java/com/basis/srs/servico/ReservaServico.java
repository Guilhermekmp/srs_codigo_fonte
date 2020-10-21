package com.basis.srs.servico;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Reserva;
import com.basis.srs.dominio.ReservaEquipamento;
import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.repositorio.ReservaEquipamentoRepositorio;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.repositorio.SalaEquipamentoRepositorio;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.dto.ReservaEquipamentoDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
import com.basis.srs.servico.exception.RegraNegocioExceptionNotFound;
import com.basis.srs.servico.mapper.ReservaMapper;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaServico {

    private final ReservaRepositorio reservaRepositorio;
    private final ReservaEquipamentoRepositorio reservaEquipamentoRepositorio;
    private final SalaRepositorio salaRepositorio;
    private final EquipamentoRepositorio equipamentoRepositorio;
    private final SalaEquipamentoRepositorio salaEquipamentoRepositorio;
    private final ReservaMapper reservaMapper;

    public List<ReservaDTO> listar(){
        List<ReservaDTO> reserva = reservaMapper.toDto(reservaRepositorio.findAll());
        return reserva;
    }

    public ReservaDTO buscar(Integer id){
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(()-> new RegraNegocioExceptionNotFound("Reserva não encontrada"));
        ReservaDTO reservaDTO = reservaMapper.toDto(reserva);
        return reservaDTO;
    }

    public ReservaDTO criar(ReservaDTO reserva){
        if (reserva.getId() != null) {
            buscar(reserva.getId());
        }
        else{
            for (Reserva reservaLista : reservaRepositorio.findAll()) {
                if (reservaLista.getSala().getId().equals(reserva.getIdSala())
                        && (reservaLista.getDataInicio().equals(reserva.getDataInicio())
                        || reservaLista.getDataFim().equals(reserva.getDataFim())
                        || reservaLista.getDataFim().isAfter(reserva.getDataInicio()))) {
                    throw new RegraNegocioException("Reserva ja existe para esse periodo");
                }
            }
        }

        Reserva novaReserva = reservaMapper.toEntity(reserva);
        List<ReservaEquipamento> reservaEquipamentos = novaReserva.getEquipamentos();
        for (SalaEquipamento salaEquipamento: salaEquipamentoRepositorio.findAll()) {
            if(salaEquipamento.getSala().equals(novaReserva.getSala())){
                for(ReservaEquipamento equipamento: reservaEquipamentos){
                    if(equipamento.getEquipamento().equals(salaEquipamento.getEquipamento())){
                        throw new RegraNegocioException("Equipamento já existe na sala reservada");
                    }
                }
            }
        }
        novaReserva.setEquipamentos(new ArrayList<>());

        reservaRepositorio.save(novaReserva);
        reservaEquipamentos.forEach(equipamento ->{
            equipamento.setReserva(novaReserva);
            equipamento.getId().setIdReserva(novaReserva.getId());
        });
        reservaEquipamentoRepositorio.saveAll(reservaEquipamentos);
        ReservaDTO reservaDTO = reservaMapper.toDto(novaReserva);
        return reservaDTO;
    }

    public void deletar(Integer id){
        buscar(id);
        reservaEquipamentoRepositorio.deleteAllByReservaId(id);
        reservaRepositorio.deleteById(id);
    }

    public Double custoTotal(ReservaDTO dto){
        Sala sala = salaRepositorio.findById(dto.getIdSala()).get();
        List<SalaEquipamento> salaEquipamentos = sala.getEquipamentos();
        List<ReservaEquipamentoDTO> reservaEquipamentos = dto.getEquipamentos();

        Double custo = sala.getPrecoDiario();

        long dias = ChronoUnit.DAYS.between(dto.getDataInicio(), dto.getDataFim());

        for (int i = 0; i < salaEquipamentos.size(); i++) {
            Equipamento equip = equipamentoRepositorio.findById(salaEquipamentos.get(i).getEquipamento().getId()).get();
            custo += equip.getPrecoDiario();
        }

        for (int i = 0; i < reservaEquipamentos.size(); i++) {
            Equipamento equip = equipamentoRepositorio.findById(reservaEquipamentos.get(i).getIdEquipamento()).get();
            custo += equip.getPrecoDiario();
        }
        custo *= dias;
        return custo;
    }

}
