package com.example.Biblioteca.Service;

import com.example.Biblioteca.Entity.Emprestimo;
import com.example.Biblioteca.Repository.EmprestimoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmprestimoRep emprestimoRep;

    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRep.findAll();
    }


}
