package com.coderhouse.springbootcoder.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="portafolio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portafolio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "phone")
    private String celular;
    @Column(name = "age")
    private Integer edad;
    @Column(name = "address")
    private String dirección;
    @Column(name = "avatarUrl")
    private String urlAvatar;
}

