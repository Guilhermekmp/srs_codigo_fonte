package com.basis.srs.builder;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Sala;
import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.dominio.TipoSala;
import com.basis.srs.repositorio.SalaRepositorio;
import com.basis.srs.servico.SalaServico;
import com.basis.srs.servico.dto.SalaDTO;
import com.basis.srs.servico.mapper.SalaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;

@Component
public class SalaBuilder extends ConstrutorDeEntidade<Sala>{

    @Autowired
    private SalaRepositorio salaRepositorio;

    @Autowired
    private SalaMapper salaMapper;

    @Autowired
    private SalaServico salaServico;

    @Autowired
    private EquipamentoBuilder equipamentoBuilder;

    @Override
    public Sala construirEntidade() throws ParseException {

        TipoSala tipoSala = new TipoSala();
        tipoSala.setId(3);
        tipoSala.setDescricao("sadasdasd");

        Sala sala = new Sala();
        sala.setCapacidade(1);
        sala.setDescricao("AAAAAAAAAAA");
        sala.setDisponivel(1);
        sala.setPrecoDiario(25.0);
        sala.setTipoSala(tipoSala);

        Equipamento equipamento = equipamentoBuilder.construir();

        SalaEquipamento salaEquipamento = new SalaEquipamento();
        salaEquipamento.setEquipamento(equipamento);
        salaEquipamento.setSala(sala);
        salaEquipamento.setQuantidade(2);

        sala.setEquipamentos(Collections.singletonList(salaEquipamento));

        return sala;
    }

    public void deletarTodos(){
        salaRepositorio.deleteAll();
    }

    public SalaDTO converterToDTo(Sala sala){
       return salaMapper.toDto(sala);
    }

    @Override
    public Sala persistir(Sala entidade) {
        SalaDTO dto = salaServico.criar(salaMapper.toDto(entidade));
        return salaMapper.toEntity(dto);
    }

    @Override
    public Collection<Sala> obterTodos() {
        return null;
    }

    @Override
    public Sala obterPorId(Long id) {
        return null;
    }
}
