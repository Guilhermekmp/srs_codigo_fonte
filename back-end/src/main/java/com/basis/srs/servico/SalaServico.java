package com.basis.srs.servico;

import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.repositorio.ReservaRepositorio;
import com.basis.srs.repositorio.SalaEquipamentoRepositorio;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.dto.EquipamentoDTO;
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
        if(novaSala.getId() == null){
            checarDuplicata(novaSala);
        }
        List<SalaEquipamento> equipamentos = novaSala.getEquipamentos();
        novaSala.setEquipamentos(new ArrayList<>());

        salaRepositorio.save(novaSala);
        equipamentos.forEach(equipamento ->{
            equipamento.setSala(novaSala);
            equipamento.getId().setIdSala(novaSala.getId());
        });

        salaEquipamentoRepositorio.saveAll(equipamentos);
        SalaDTO salaDTO = salaMapper.toDto(novaSala);

        return salaDTO;
    }

    private void checarDuplicata(Sala novaSala){
        for(SalaDTO salaInstancia: listar()){
            if(salaInstancia.getDescricao().equals(novaSala.getDescricao())){
                throw new RegraNegocioException("Salas duplicadas");
            }
        }
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

    public List<EquipamentoDTO> listarEquipamentosOpcionais(SalaDTO dto){
        Sala sala = salaMapper.toEntity(dto);
        List<EquipamentoDTO> listaEquipamentoOpc = equipamentoServico.listar();
        for (EquipamentoDTO equipamento:listaEquipamentoOpc) {
            boolean obrigatorio = false;
            for (SalaEquipamento equipamentoObrigatorio :sala.getEquipamentos()) {
                if(equipamentoObrigatorio.getId().getIdEquipamento().equals(equipamento.getId())){
                   obrigatorio = true;
                }
            }
            if(obrigatorio){
                listaEquipamentoOpc.remove(equipamento);
            }
        }
        return listaEquipamentoOpc;
    }
}

