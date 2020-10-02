
package com.basis.srs.servico;
import com.basis.srs.dominio.TipoEquipamento;
import com.basis.srs.repositorio.TipoEquipamentoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TipoEquipamentoServico {

    private TipoEquipamentoRepositorio tipoEquipamentoRepositorio;

    public TipoEquipamento cadastrarTipoEquipamento(TipoEquipamento novoTipoEquipamento){
        return null;
    }

    public List<TipoEquipamento> buscarTodos(){
        return null;
    }

    public TipoEquipamento buscarId(Integer id){
        return null;
    }

    public void deletar(Integer id){
    }

    public void atualizar(){
    }
}
