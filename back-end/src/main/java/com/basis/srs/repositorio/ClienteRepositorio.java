package com.basis.srs.repositorio;


import com.basis.srs.dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

}
