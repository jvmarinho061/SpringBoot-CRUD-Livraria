package CRUD.livraria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CRUD.livraria.model.Livro;
import CRUD.livraria.service.LivroService;

@RestController
@RequestMapping("/livros") // Define a rota base
public class LivroController {
    private final LivroService livroService;
    public LivroController(LivroService livroService) {
        this.livroService = livroService; // Injeção de dependência do LivroService
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        try {
            Livro salvo = livroService.cadastrar(livro);
            return ResponseEntity.ok(salvo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); // Escritor não existe
        }
    }
         @GetMapping("/por-autor/{nomeAutor}")
    public ResponseEntity<List<Livro>> buscarPorAutor(@PathVariable String nomeAutor) { // Método para buscar livros por autor
        List<Livro> livros = livroService.buscarPorEscritor(nomeAutor);
        return livros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(livros);
        
    }
}
