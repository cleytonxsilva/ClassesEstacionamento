package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "marca", schema = "public")
public class Marca extends AbstractEntity{
    @Getter
    @Column(name = "id_marca",nullable = false, unique = true)
    private Long idMarca;
    @Getter @Setter
    @Column(name = "nome_marca", nullable = false, unique = true, length = 50)
    private String nomeMarca;
}
