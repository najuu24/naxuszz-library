package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRep extends JpaRepository<Emprestimo, Long> {
}
