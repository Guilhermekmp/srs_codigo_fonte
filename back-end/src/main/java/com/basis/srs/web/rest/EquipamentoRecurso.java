package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.servicos.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.List;

@Resource
@RequestMapping("/equipamentos")
@RequiredArgsConstructor
public class EquipamentoRecurso {

    private final EquipamentoServico servicoUsuario;

    public EquipamentoRecurso(EquipamentoServico servicoUsuario) {
        this.servicoUsuario = servicoUsuario;
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> obter(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> obterPorId(@PathVariable int id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Equipamento> cadastro(@RequestBody Equipamento newEquipamento){
        return null;
    }

    @PutMapping
    public ResponseEntity<Equipamento> atualizar(@RequestBody Equipamento newEquipamento){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Equipamento> deletar(){
        return null;
    }
}
