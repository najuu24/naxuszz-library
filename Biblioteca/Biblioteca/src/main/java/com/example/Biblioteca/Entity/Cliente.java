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
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<Emprestimo> emprestimo;

    public Cliente(Long idCliente, String nome, String sobrenome, String cpf){
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
}
