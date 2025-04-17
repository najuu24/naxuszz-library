package com.example.Biblioteca.Controller;


import com.example.Biblioteca.DTO.LivroDTO;
import com.example.Biblioteca.Entity.Livro;
import com.example.Biblioteca.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> getAll(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String genero ){ // @RequestParam vai pegar o valor de "?nome=NomeLivro", no caso "NomeLivro" realizar o filtro
        if(nome != null && !nome.isEmpty()){
            return livroService.getAllByName(nome);
        }else if(genero != null && !genero.isEmpty()){
            return livroService.getAllByGenero(genero);
        }
        return livroService.getAll();
    }

    @GetMapping("/{idLivro}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long idLivro){
        Optional<LivroDTO> livroDTOOptional = livroService.getById(idLivro);
        if(livroDTOOptional.isPresent()){
            return ResponseEntity.ok(livroDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO livroDTO){
        LivroDTO livroDTOSave = livroService.create(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDTOSave);
    }

    @PutMapping("/{idLivro}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long idLivro, @RequestBody LivroDTO livroDTO){
        Optional<LivroDTO> livroDTOOptional = livroService.update(idLivro, livroDTO);
        if(livroDTOOptional.isPresent()){
            return ResponseEntity.ok(livroDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idLivro}")
    public ResponseEntity<Void> delete(@PathVariable Long idLivro){
        if(livroService.delete(idLivro)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
