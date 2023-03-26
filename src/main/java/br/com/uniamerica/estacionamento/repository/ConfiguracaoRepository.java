package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Movimentacao, Long> {
    @Override
    List<Movimentacao> findAllById(Iterable<Long> longs);

    @Override
    Optional<Movimentacao> findById(Long aLong);
    @Override
    List<Movimentacao> findAll();
}
