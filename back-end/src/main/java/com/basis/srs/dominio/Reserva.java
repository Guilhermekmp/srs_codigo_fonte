package com.basis.srs.dominio;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Getter
@Setter
@Table(name = "reserva")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sala")
    private Sala sala;

    @Column(name="total")
    private double total;

    @Column(name = "dt_ini")
    private Date dtIni;

    @Column(name= "dt_fin")
    private Date dtFin;

}
