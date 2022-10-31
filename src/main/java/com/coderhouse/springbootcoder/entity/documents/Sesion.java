package com.coderhouse.springbootcoder.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "sesion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sesion implements Serializable {
    @Id
    @Column(name = "sessionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSesion;
    @Column(name = "startedAt")
    private Date iniciadoALas;
    @Column(name = "deviceUid", unique = true, nullable = false)
    private String idDispositivo;
    @Column(name = "deviceName")
    private String nombreDispositivo;

//    @JsonIgnore
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false)
    private Usuario usuarioUsuario;
}

