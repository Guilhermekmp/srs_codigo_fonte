package com.basis.srs.servico;

import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.repositorio.SalaEquipamentoRepositorio;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.ReservaDTO;
import com.basis.srs.servico.dto.SalaDTO;
import com.basis.srs.servico.exception.RegraNegocioException;
import com.basis.srs.servico.mapper.SalaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SalaServico {

    private final SalaRepositorio salaRepositorio;
    private final SalaEquipamentoRepositorio salaEquipamentoRepositorio;
    private final SalaMapper salaMapper;
    private final EquipamentoRepositorio equipamentoRepositorio;
    private final ReservaRepositorio reservaRepositorio;
    private final ReservaServico reservaServico;
    private final EquipamentoServico equipamentoServico;

    public List<SalaDTO> listar(){
        List<Sala> salas = salaRepositorio.findAll();
        List<SalaDTO> salaDTOS = salaMapper.toDto(salas);
        return salaDTOS;
    }

    public SalaDTO buscar(Integer id) throws RegraNegocioException{
        Sala sala = salaRepositorio.findById(id).orElseThrow(()-> new RegraNegocioException("Sala não encontrada"));
        SalaDTO salaDTO = salaMapper.toDto(sala);
        return salaDTO;
    }

    public SalaDTO criar(SalaDTO sala) throws RegraNegocioException{
        Sala novaSala = salaMapper.toEntity(sala);
        List<SalaEquipamento> equipamentos = novaSala.getEquipamentos();
        novaSala.setEquipamentos(new ArrayList<>());

        for(SalaDTO salaInstancia: listar()){
            if(salaInstancia.getDescricao().equals(novaSala.getDescricao())  || salaInstancia.getEquipamentos().equals(sala.getEquipamentos())){
                throw new RegraNegocioException("Salas duplicadas");
            }
        }

        salaRepositorio.save(novaSala);
        equipamentos.forEach(equipamento ->{
            equipamento.setSala(novaSala);
            equipamento.getId().setIdSala(novaSala.getId());
        });
        salaEquipamentoRepositorio.saveAll(equipamentos);
        SalaDTO salaDTO = salaMapper.toDto(novaSala);

        return salaDTO;
    }

    public void deletar(Integer id) throws RegraNegocioException{
        for (ReservaDTO reserva: reservaServico.listar()) {
                if(reserva.getIdSala() == id){
                    throw new RegraNegocioException("Sala reservada não pode ser deletada");
                }
            }

        buscar(id);

        salaRepositorio.deleteById(id);
        }

    public boolean ehReservada(Integer id){
        for (ReservaDTO reserva: reservaServico.listar()) {
            if(reserva.getIdSala() == id){
                return true;
            }
        }
        return false;
    }
}

