package com.example.Biblioteca.Service;

import com.example.Biblioteca.DTO.EmpDTO;
import com.example.Biblioteca.Entity.Emprestimo;
import com.example.Biblioteca.Repository.EmprestimoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmprestimoRep emprestimoRep;

    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRep.findAll();
    }

    public Optional<EmpDTO> getById(Long id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRep.findById(id);
        if(emprestimoOptional.isPresent()){
            EmpDTO emprestimoDTO = new EmpDTO();
            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimoOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public EmpDTO create(EmpDTO emprestimoDTO){
        Emprestimo emprestimo = emprestimoDTO.toEmprestimo();
        emprestimo = emprestimoRep.save(emprestimo);
        return emprestimoDTO.fromEmprestimo(emprestimo);
    }

    public Optional<EmpDTO> update(Long id, EmpDTO emprestimoDTO){
        Optional<Emprestimo> emprestimoOptional = emprestimoRep.findById(id);
        if(emprestimoOptional.isPresent()){
            Emprestimo emprestimo = emprestimoOptional.get();
            emprestimo.setDataFinal(emprestimoDTO.getDataFinal());
            emprestimo.setLivros(emprestimoDTO.getLivros());

            emprestimo = emprestimoRep.save(emprestimo);

            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimo));
        }else{
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(emprestimoRep.existsById(id)){
            emprestimoRep.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
