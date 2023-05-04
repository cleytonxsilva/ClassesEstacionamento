package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Marca;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaService {
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Marca marca) {

    }
}
