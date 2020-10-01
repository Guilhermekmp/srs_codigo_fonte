package com.basis.srs.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @NoArgsConstructor
@Table(name = "reservas")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="total")
    private double total;
    @Column(name = "dt_ini")
    private Date dtIni;
    @Column(name= "dt_fin")
    private Date dtFin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_sala", referencedColumnName = "id")
    private Sala sala;
}
