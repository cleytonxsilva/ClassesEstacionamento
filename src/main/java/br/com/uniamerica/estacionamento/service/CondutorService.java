package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {
    @Autowired
    private CondutorRepository condutorRepository;
    private MovimentacaoRepository movimentacaoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Condutor condutor) {

    }

    public Optional<Condutor> findById(Long id) {
        return condutorRepository.findById(id);
    }

    public List<Condutor> findAll() {
        return condutorRepository.findAll();
    }

    public List<Condutor> findByAtivo(boolean ativo) {
        return condutorRepository.findByAtivo(true);
    }

    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Condutor condutor){
        try{
            final Condutor condutorBanco = this.condutorRepository.findById(id).orElse(null);

            if(condutorBanco == null || !condutorBanco.getId().equals(condutor.getId()))
            {
                throw new RuntimeException("Não foi possível identificar o registro informado");
            }

            this.condutorRepository.save(condutor);
            return ResponseEntity.ok("Registro editado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error " + e.getMessage());
        }
    }

    public ResponseEntity<?> excluir(@RequestParam("id") final Long id){
        try {
            final Condutor condutor = this.condutorRepository.findById(id).orElse(null);
            if(condutor == null){
                throw new Exception("Registro inexistente");
            }

            final List<Movimentacao> movimentacoes = this.movimentacaoRepository.findAll();
            for(Movimentacao movimentacao : movimentacoes){
                if(condutor.equals(movimentacao.getCondutor())){
                    condutor.setAtivo(false);
                    this.condutorRepository.save(condutor);
                    return ResponseEntity.ok("Registro não está ativo");
                }
            }

            if(condutor.isAtivo()){
                this.condutorRepository.delete(condutor);
                return ResponseEntity.ok("Registro deletado com sucesso");
            }
            else{
                throw new Exception("Não foi possível excluir o registro");
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error" + e.getMessage());
        }
    }

    public void save(Condutor condutor) {
    }
}
