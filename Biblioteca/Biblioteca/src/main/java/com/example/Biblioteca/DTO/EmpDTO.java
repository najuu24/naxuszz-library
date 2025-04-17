package com.example.Biblioteca.DTO;


import com.example.Biblioteca.Entity.Cliente;
import com.example.Biblioteca.Entity.Emprestimo;
import com.example.Biblioteca.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO implements Serializable {
    private Long idEmp;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Cliente cliente;
    private List<Livro> livros;

    public Emprestimo toEmprestimo(){
        return new Emprestimo(
                this.idEmp,
                this.dataInicial,
                this.dataFinal,
                this.getCliente(),
                this.livros
        );
    }

    public EmpDTO fromEmprestimo(Emprestimo emprestimo){
        return new EmpDTO(
                emprestimo.getIdEmp(),
                emprestimo.getDataInicial(),
                emprestimo.getDataFinal(),
                emprestimo.getCliente(),
                emprestimo.getLivros()
        );
    }
}
