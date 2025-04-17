package com.example.Biblioteca.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nome;
    private String autor;
    @Column(unique = true)
    private int ISBN;
    private String genero;

    @ManyToMany(mappedBy = "livros")
    @JsonIgnore
    private Set<Emprestimo> emprestimos;

    public Livro(Long id, String nome, String autor, int ISBN, String genero){
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
    }
}
