package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/modelo")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;

    /*public ModeloController(ModeloRepository modeloRepository){
        this.modeloRepository = modeloRepository;
        }*/

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findByIdPath(@PathVariable("id") final Long id){
        return ResponseEntity.ok(new Modelo());
    }

    @GetMapping
    public ResponseEntity<Modelo> findByIdPath(@RequestParam("id") final Long id){
        return ResponseEntity.ok(new Modelo());
    }

    @GetMapping

    @PostMapping

    @PutMapping

    @DeleteMapping
}
