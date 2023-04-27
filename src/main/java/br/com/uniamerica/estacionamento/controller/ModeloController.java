package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/modelo")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;

    /*
    public ModeloController(ModeloRepository modeloRepository){
        this.modeloRepository = modeloRepository;}
    */

    /* http://localhost:8080/api/modelo/1 */
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Modelo modelo = this.modeloRepository.findById(id).orElse(null);
        return modelo == null
            ? ResponseEntity.badRequest().body("Nenhum valor encontrado")
            : ResponseEntity.ok(modelo);
    }

    /* http://localhost:8080/api/modelo?id=1 */
    @GetMapping
    public ResponseEntity<?> findByIdRequest(@RequestParam("id") final Long id){
        final Modelo modelo = this.modeloRepository.findById(id).orElse(null);
        return modelo == null
            ? ResponseEntity.badRequest().body("Nenhum valor encontrado")
            : ResponseEntity.ok(modelo);
    }
    /* http://localhost:8080/api/modelo/lista */
    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.modeloRepository.findAll());
    }

    /* http://localhost:8080/api/modelo --POST */
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Modelo modelo){
        this.modeloRepository.save(modelo);
        return ResponseEntity.ok("Registro cadastrado com sucesso");
    }

//    @PutMapping
//    public ResponseEntity<?> editar(
//            @RequestParam("id") final Long id,
//            @RequestBody final Modelo modelo
//            ){
//        final Modelo modeloBanco = this.modeloRepository.findById(id).orElse(null);
//        if(modeloBanco == null || modeloBanco.getId().equals(modelo.getId())){
//            throw new RuntimeException("Não foi possivel identificar o registro informado");
//        }
//
//    }

    /* http://localhost:8080/api/modelo --DELETE */
    @DeleteMapping
    public ResponseEntity<?> excluir(@RequestBody final Modelo modelo){
    this.modeloRepository.delete(modelo);
    return ResponseEntity.ok("Registro excluido com sucesso");
}

}
