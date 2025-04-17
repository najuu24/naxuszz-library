package com.example.Biblioteca.DTO;


import com.example.Biblioteca.Entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Long idCliente;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String foto;

    public Cliente toCliente(){
        return new Cliente(
                this.idCliente,
                this.nome,
                this.sobrenome,
                this.cpf
        );
    }

    public ClienteDTO fromCliente(Cliente cliente){
        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getCpf(),
                cliente.getNome()
        );
    }
}
