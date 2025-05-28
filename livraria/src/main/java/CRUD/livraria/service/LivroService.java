package CRUD.livraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import CRUD.livraria.model.Livro;
import CRUD.livraria.repository.LivroRepository;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final EscritorService escritorService;

    public LivroService(LivroRepository livroRepository, EscritorService escritorService) {
        this.livroRepository = livroRepository;
        this.escritorService = escritorService;
    }

    //CRUD com validação de escritor existente 
    public Livro cadastrar(Livro livro) {
        if(livro.getEscritor() == null || livro.getEscritor().getId_autor() == null) { 
            throw new RuntimeException("Escritor não pode ser encontrado.");
        }
        // Verifica se o escritor existe
        escritorService.buscarPorId(livro.getEscritor().getId_autor())
            .orElseThrow(() -> new RuntimeException("Escritor não encontrado."));
        return livroRepository.save(livro);
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> buscarPorEscritor(String nomeAutor) {
        return livroRepository.findByEscritorNome(nomeAutor);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

}
