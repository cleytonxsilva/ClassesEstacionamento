package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Override
    List<Marca> findAllById(Iterable<Long> longs);
    @Override
    Optional<Marca> findById(Long aLong);
    @Override
    List<Marca> findAll();
}
