package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/configuracao")
public class ConfiguracaoController {
    @Autowired
    private ConfiguracaoService configuracaoService;

    @GetMapping
    public ResponseEntity<?> findByIdRequest(@RequestParam("id") final Long id){
        final Configuracao configuracao = this.configuracaoService.findById(id).orElse(null);
        return configuracao == null
                ? ResponseEntity.badRequest().body("Nenhum valor encontrado")
                : ResponseEntity.ok(configuracao);
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Configuracao configuracao) {
        try {
            this.configuracaoService.cadastrar(configuracao);
            return ResponseEntity.ok("Registro cadastrado com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.internalServerError().body("Error" + e.getCause().getCause().getMessage());
        }
    }
    public ResponseEntity<?> editar(@RequestParam("id") final Long id, @RequestBody final Configuracao configuracao){
        try{
            final Configuracao configuracaoBanco = this.configuracaoService.findById(id).orElse(null);

            if(configuracaoBanco == null || configuracaoBanco.getId().equals(configuracao.getId()))
            {
                throw new RuntimeException("Não foi possível identificar o registro informado");
            }

            this.configuracaoService.cadastrar(configuracao);
            return ResponseEntity.ok("Registro editado com sucesso");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error " + e.getMessage());
        }
    }
}
