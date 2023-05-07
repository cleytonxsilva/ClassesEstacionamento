package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class CondutorService {
    @Autowired
    private CondutorRepository condutorRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Condutor condutor) {
        if(isNull(condutor.getNomeCondutor()) || isNull((condutor.getCpf())) || isNull(condutor.getTelefone())){
            throw new RuntimeException("Nome,CPF e Telefone são obrigatórios");
        }
        Condutor findByCpf = condutorRepository.findByCpf(condutor);
        if(!isNull(findByCpf)){
            throw new RuntimeException("CPF já cadastrado");
        }
        condutorRepository.save(condutor);
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


    @Transactional(rollbackFor = Exception.class)
    public void excluir (final Long id){
        Optional<Condutor> excluirCondutor = condutorRepository.findById(id);
        if(isNull(excluirCondutor)){
            throw new RuntimeException("Condutor não encontrado");
        }
        condutorRepository.deleteById(id);
    }
}
