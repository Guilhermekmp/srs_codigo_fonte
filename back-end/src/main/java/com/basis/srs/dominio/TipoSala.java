package com.basis.srs.dominio;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tipo_sala")
public class TipoSala implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_sala")
    @SequenceGenerator(name="sq_sala", allocationSize = 1, sequenceName = "sq_sala")
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;
}
