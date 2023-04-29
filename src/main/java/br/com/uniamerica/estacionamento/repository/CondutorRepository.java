package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long>{

//    @Query("SELECT * FROM AbstractEntity WHERE ativo = ?", nativeQuery = true)
//    List<Condutor> findByAtivos(Boolean ativo);
//
//    List<Condutor> findByAtivos();
}
