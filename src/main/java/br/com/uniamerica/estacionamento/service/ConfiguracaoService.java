package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfiguracaoService {
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Configuracao configuracao) {

    }
}
