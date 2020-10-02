package com.basis.srs.repositorio;

import com.basis.srs.dominio.TipoSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSalaRepositorio extends JpaRepository<TipoSala, Integer> {
}
