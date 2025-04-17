package com.example.Biblioteca.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_livro",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;
}
