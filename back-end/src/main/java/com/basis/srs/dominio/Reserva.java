package com.basis.srs.dominio;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Data @NoArgsConstructor
@Table(name = "reservas")
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cliente", referencedColumnName = "id")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_sala", referencedColumnName = "id")
    private Sala sala;
    @Column(name="total")
    private double total;
    @Column(name = "dt_ini")
    private Date dtIni;
    @Column(name= "dt_fin")
    private Date dtFin;

}
