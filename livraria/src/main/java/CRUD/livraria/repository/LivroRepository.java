package CRUD.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import CRUD.livraria.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // consulta personalizada: busca de llivros por nome do autor (JPQL) 
    //linguagem de consulta orientada a objetos utilizada para interagir com bancos de dados relacionais usando a especificação JPA (Java Persistence API)
    @Query("SELECT l FROM Livro l JOIN l.escritor e WHERE e.nome = :nomeAutor")
    List<Livro> findByEscritorNome(String nomeAutor);

    //Consulta derivada: busca de livros por editora
    List<Livro> findByEditora(String editora);
}
