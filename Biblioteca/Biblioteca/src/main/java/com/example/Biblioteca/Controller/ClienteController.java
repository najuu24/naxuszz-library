package com.example.Biblioteca.Controller;


import com.example.Biblioteca.DTO.ClienteDTO;
import com.example.Biblioteca.Entity.Cliente;
import com.example.Biblioteca.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long idCliente){
        Optional<ClienteDTO> clienteDTOOptional = clienteService.getById(idCliente);
        if(clienteDTOOptional.isPresent()){
            return ResponseEntity.ok(clienteDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO clienteDTOSave = clienteService.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTOSave);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long idCliente, @RequestBody ClienteDTO clienteDTO){
        Optional<ClienteDTO> clienteDTOOptional = clienteService.updateCliente(idCliente, clienteDTO);
        if(clienteDTOOptional.isPresent()){
            return ResponseEntity.ok(clienteDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> delete(@PathVariable Long idCliente){
        if(clienteService.delete(idCliente)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
