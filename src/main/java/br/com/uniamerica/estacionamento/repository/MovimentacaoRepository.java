package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    boolean existsByCondutor(Condutor condutor);

    List<Movimentacao> findBySaidaIsNull();
}
