package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VeiculoService {
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Veiculo veiculo) {

    }
}