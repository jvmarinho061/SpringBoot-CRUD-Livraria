package CRUD.livraria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CRUD.livraria.model.Escritor;
import CRUD.livraria.service.EscritorService;

@RestController
@RequestMapping("/escritores") //define a rota base para este controller
public class EscritorController {
    private final EscritorService escritorService;

    public EscritorController(EscritorService escritorService) {
        this.escritorService = escritorService;
    } // Injeção de dependência do EscritorService

    @PostMapping
    public ResponseEntity<Escritor> cadastrar(@RequestBody Escritor escritor) {
        if(escritorService.emailExiste(escritor.getEmail())) {
            return ResponseEntity.badRequest().build(); // Email duplicado, retorna Bad Request
        }

        Escritor salvo = escritorService.cadastrar(escritor);
        return ResponseEntity.ok(salvo); // Retorna OK com o escritor salvo
    }

    @GetMapping("{id}")
    public ResponseEntity<Escritor> buscarPorId(@PathVariable Long id) {
        return escritorService.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Retorna OK com o escritor ou Not Found
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        escritorService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna No Content após deletar
    }
}
