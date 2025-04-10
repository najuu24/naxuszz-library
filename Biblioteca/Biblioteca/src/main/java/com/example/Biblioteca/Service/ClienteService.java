package com.example.Biblioteca.Service;

import com.example.Biblioteca.Entity.Cliente;
import com.example.Biblioteca.Repository.ClienteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRep clienteRep;

    public List<Cliente> getAllClientes() {
        return clienteRep.findAll();
    }

    // linha 28 do produtoservice
}
