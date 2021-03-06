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

    public SalaDTO criar(SalaDTO salaDTO) throws RegraNegocioException{

        if(salaDTO.getId() != null){
            Sala sala = salaRepositorio.findById(salaDTO.getId()).orElseThrow(() -> new RegraNegocioException(("Essa sala não existe")));
        }
        else{
            checarDuplicata(salaDTO);
        }
        Sala sala2 = salaMapper.toEntity(salaDTO);
        List<SalaEquipamento> novosEquipamentos = sala2.getEquipamentos();
        sala2.setEquipamentos(new ArrayList<>());
        salaRepositorio.save(sala2);
        novosEquipamentos.forEach(equipamento -> {
            equipamento.setSala(sala2);
            equipamento.getId().setIdSala(sala2.getId());
        });
        salaEquipamentoRepositorio.saveAll(novosEquipamentos);
        sala2.setEquipamentos(novosEquipamentos);
        return salaMapper.toDto(sala2);

    }

    private void checarDuplicata(SalaDTO novaSala){
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

    public List<EquipamentoDTO> listarEquipamentosOpcionais(Integer id){
        Sala sala = salaRepositorio.findById(id).get();
        List<EquipamentoDTO> listaEquipamentoOpc = equipamentoServico.listar();
        List<EquipamentoDTO> listaAdicionados = new ArrayList<>();
        for (EquipamentoDTO equipamento:listaEquipamentoOpc) {
            boolean obrigatorio = false;
            for (SalaEquipamento equipamentoObrigatorio :sala.getEquipamentos()) {
                if(equipamentoObrigatorio.getId().getIdEquipamento().equals(equipamento.getId())){
                   obrigatorio = true;
                }
            }
            if(!obrigatorio){
                listaAdicionados.add(equipamento);
            }
        }
        return listaAdicionados;
    }
}

