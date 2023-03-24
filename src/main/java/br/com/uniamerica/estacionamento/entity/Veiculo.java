package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "veiculo", schema = "public")
public class Veiculo extends AbstractEntity{
    @Getter
    @Column(name = "id_veiculo", nullable = false, unique = true)
    private Long idVeiculo;
    @Getter @Setter
    @Column(name = "placa_carro",nullable = false,unique = true, length = 10)
    private String placaCarro; //not null / unique /tamanho 10
    @Getter @Setter
    @Column(name = "ano_carro",nullable = false)
    private int anoCarro; //not null
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "modelo_carro", nullable = false)
    private Modelo modeloCarro;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "cor", nullable = false, length = 20)
    private Cor cor;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(name = "tipo_veiculo", nullable = false, length = 6)
    private TipoVeiculo tipo;

}
