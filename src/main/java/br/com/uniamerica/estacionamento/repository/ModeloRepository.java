package br.com.uniamerica.estacionamento.repository;
import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    List<Modelo> findByAtivo(boolean ativo);

    public List<Modelo> findByAtivoIsTrue();

    @Query("select n from Modelo n where n.modelo = :#{#modelo}")
    Marca findByModelo(@Param("modelo")Modelo nome);
}
