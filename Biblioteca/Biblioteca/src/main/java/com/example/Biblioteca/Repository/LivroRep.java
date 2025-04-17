package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRep extends JpaRepository<Livro, Long> {
    List<Livro> findAllByNome(String nome);
}
