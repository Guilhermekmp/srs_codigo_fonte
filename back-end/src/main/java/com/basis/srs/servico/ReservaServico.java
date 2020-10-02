package com.basis.srs.servico;

import com.basis.srs.dominio.Reserva;
import com.basis.srs.repositorio.ReservaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservaServico {

    private ReservaRepositorio repositorio;

    public List<Reserva> listar(){
        return null;
    }

    public Reserva procurar(Integer id){
        return null;
    }

    public Reserva criar(Reserva reserva){
        return null;
    }

    public Reserva deletar(Integer id){
        return null;
    }

    public Reserva  alterar(Reserva reserva){
        return null;
    }

}
