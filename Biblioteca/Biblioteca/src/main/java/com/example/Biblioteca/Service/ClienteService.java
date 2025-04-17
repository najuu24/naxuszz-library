package com.example.Biblioteca.Service;

import com.example.Biblioteca.DTO.ClienteDTO;
import com.example.Biblioteca.Entity.Cliente;
import com.example.Biblioteca.Repository.ClienteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRep clienteRep;

    @GetMapping
    public List<Cliente> getAll() {@RequestParam(required = false) String nome,
            @RequestParam(required = false) String
        return clienteRep.findAll();
    }

    public Optional<ClienteDTO> getById(Long idCliente){
        Optional<Cliente> clienteOptional = clienteRep.findById(idCliente);
        if(clienteOptional.isPresent()){
            ClienteDTO produtoDTO = new ClienteDTO();
            return Optional.of(produtoDTO.fromCliente(clienteOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRep.save(cliente);
        return clienteDTO.fromCliente(cliente);
    }

    public Optional<ClienteDTO> updateCliente(Long idCliente, ClienteDTO clienteDTO){
        Optional<Cliente> clienteOptional = clienteRep.findById(idCliente);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setSobrenome(clienteDTO.getSobrenome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente = clienteRep.save(cliente);
            return Optional.of(clienteDTO.fromCliente(cliente));
        }else{
            return Optional.empty();
        }
    }

    public boolean delete(Long idCliente){
        if(clienteRep.existsById(idCliente)){
            clienteRep.deleteById(idCliente);
            return true;
        }else {
            return false;
        }
    }
}
