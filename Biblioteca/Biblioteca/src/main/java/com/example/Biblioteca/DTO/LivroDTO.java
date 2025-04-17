package com.example.Biblioteca.DTO;


import com.example.Biblioteca.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO implements Serializable {
    private Long idLivro;
    private String nome;
    private String autor;
    private int ISBN;
    private String genero;

    public Livro toLivro(){
        return new Livro(
                this.idLivro,
                this.nome,
                this.autor,
                this.ISBN,
                this.genero
        );
    }

    public LivroDTO fromLivro(Livro livro){
        return new LivroDTO(
                livro.getIdLivro(),
                livro.getNome(),
                livro.getAutor(),
                livro.getISBN(),
                livro.getGenero()
        );
    }
}
