package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CondutorService {
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Condutor condutor) {

    }
}
