package com.example.Biblioteca.Service;

import com.example.Biblioteca.DTO.LivroDTO;
import com.example.Biblioteca.Entity.Livro;
import com.example.Biblioteca.Repository.LivroRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    public LivroRep livroRepository;

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public List<Livro> getAllByName(String nome){
        return livroRepository.findAllByNome(nome);
    }

    public List<Livro> getAllByGenero(String genero) {
    }

    public Optional<LivroDTO> getById(Long idLivro){
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        if(livroOptional.isPresent()){
            LivroDTO livroDTO = new LivroDTO();
            return Optional.of(livroDTO.fromLivro(livroOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public LivroDTO create(LivroDTO livroDTO){
        Livro livro = livroDTO.toLivro();
        livro = livroRepository.save(livro);
        return livroDTO.fromLivro(livro);
    }

    public Optional<LivroDTO> update(Long idLivro, LivroDTO livroDTO){
        Optional<Livro> livroOptional = livroRepository.findById(idLivro);
        if(livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livro.setNome(livroDTO.getNome());
            livro.setAutor(livroDTO.getAutor());
            livro.setISBN(livroDTO.getISBN());
            livro.setGenero(livro.getGenero());

            livro = livroRepository.save(livro);

            return Optional.of(livroDTO.fromLivro(livro));
        }else{
            return Optional.empty();
        }
    }

    public boolean delete(Long idLivro){
        if(livroRepository.existsById(idLivro)){
            livroRepository.deleteById(idLivro);
            return true;
        }else {
            return false;
        }
    }


}
