package com.basis.srs.repositorio;

import com.basis.srs.dominio.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT COUNT(p) FROM Cliente p WHERE p.cpf = :cpf")
    Integer findByCpf(@Param("cpf") String cpf);

}
