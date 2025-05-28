package CRUD.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_livro;

    @NotBlank(message = "O título do livro é obrigatório.")
    private String titulo;

    @ManyToOne // Relacionamento com Autor
    @JoinColumn(name = "id_autor", nullable = false)  // Chave estrangeira para Escritor
    private Escritor escritor;

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private Double preco;

    @NotBlank(message = "A editora é obrigatória.")
    private String editora;

    @Positive(message = "Ano de publicação deve ser válido.")
    private int ano_publicacao;

    public Long getId_livro() {
        return id_livro;
    }

    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Escritor getEscritor() {
        return escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    
}
