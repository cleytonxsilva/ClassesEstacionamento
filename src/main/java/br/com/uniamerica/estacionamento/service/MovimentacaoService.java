package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovimentacaoService {
    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(final Movimentacao movimentacao) {

    }
}