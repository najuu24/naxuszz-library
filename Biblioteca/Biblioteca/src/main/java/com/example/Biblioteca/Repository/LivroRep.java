package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRep extends JpaRepository<Livro, Long> {
}
