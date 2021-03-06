package com.basis.srs.repositorio;

import com.basis.srs.dominio.SalaEquipamento;
import com.basis.srs.dominio.SalaEquipamentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaEquipamentoRepositorio extends JpaRepository<SalaEquipamento, SalaEquipamentoId> {

    void deleteAllBySalaId(Integer id);
}
