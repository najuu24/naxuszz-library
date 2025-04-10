package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRep extends JpaRepository<Cliente, Long> {
}
