package com.basis.srs.builder;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.TipoEquipamento;
import com.basis.srs.repositorio.EquipamentoRepositorio;
import com.basis.srs.servico.EquipamentoServico;
import com.basis.srs.servico.dto.EquipamentoDTO;
import com.basis.srs.servico.mapper.EquipamentoMapper;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EquipamentoBuilder extends ConstrutorDeEntidade<Equipamento>{

    private final EquipamentoServico equipamentoServico;
    private final EquipamentoRepositorio equipamentoRepositorio;
    private final EquipamentoMapper equipamentoMapper;

    @Override
    public Equipamento construirEntidade(){
        TipoEquipamento tipoEquipamento = new TipoEquipamento();
        tipoEquipamento.setDescricao("Lendário");
        tipoEquipamento.setId(3);
        Equipamento equipamento = new Equipamento();
        equipamento.setNome("Teste");
        equipamento.setObrigatorio(0);
        equipamento.setPrecoDiario(20.00);
        equipamento.setTipoEquipamento(tipoEquipamento);
        return equipamento;
    }

    @Override
    public Equipamento persistir(Equipamento entidade) {
        EquipamentoDTO dto = equipamentoServico.criar(equipamentoMapper.toDto(entidade));
        return equipamentoMapper.toEntity(dto);
    }

    @Override
    public Collection<Equipamento> obterTodos() {
        return null;
    }

    @Override
    public Equipamento obterPorId(Long id) {
        return null;
    }

    public void limparBanco() {
        equipamentoRepositorio.deleteAll();
    }

    public EquipamentoDTO construirToDto(Equipamento equipamento) {
        return equipamentoMapper.toDto(equipamento);
    }

}
