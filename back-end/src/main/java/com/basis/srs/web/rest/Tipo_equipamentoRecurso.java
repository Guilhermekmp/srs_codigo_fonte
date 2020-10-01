package com.basis.srs.web.rest;

import com.basis.srs.dominio.Equipamento;
import com.basis.srs.dominio.Tipo_equipamento;
<<<<<<< HEAD
import com.basis.srs.servico.dto.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

=======
import com.basis.srs.servicos.EquipamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
>>>>>>> 29fa5757e5af54de55a3f2cd8cf16df04a082e48
import java.util.List;

@RestController
@RequestMapping("/api/equipamentos")
@RequiredArgsConstructor
public class Tipo_equipamentoRecurso {
    private EquipamentoServico equipamentoServico;

    @GetMapping
    public List<Tipo_equipamento> obter(){
        return null;
    }
    @GetMapping("/{id}")
    public Tipo_equipamento obterPorId(@PathVariable int id){
        return null;
    }
    @PostMapping
    public Equipamento cadastrar(@RequestBody Tipo_equipamento tipo_equipamento){
        return null;
    }
    @PutMapping
    public Equipamento atualizar(@RequestBody Tipo_equipamento tipo_equipamento){
        return null;
    }
    @DeleteMapping
    public Equipamento deletar(){
        return null;
    }
}
