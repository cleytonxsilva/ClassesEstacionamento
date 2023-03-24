package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "modelo", schema = "public")
public class Modelo extends AbstractEntity{
    @Getter
    @Column(name = "id_modelo",nullable = false, unique = true)
    private Long idModelo;
    @Getter @Setter
    @Column(name = "nome_modelo",nullable = false, unique = true, length = 50)
    private String nomeModelo;
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_carro", nullable = false)
    private Marca marcaCarro;

}
