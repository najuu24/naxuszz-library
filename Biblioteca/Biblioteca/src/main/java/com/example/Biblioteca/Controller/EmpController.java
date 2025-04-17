package com.example.Biblioteca.Controller;

import com.example.Biblioteca.DTO.EmpDTO;
import com.example.Biblioteca.Entity.Emprestimo;
import com.example.Biblioteca.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimo")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public List<Emprestimo> getAll(){
        return empService.getAllEmprestimos();
    }

    @GetMapping("/{idEmp}")
    public ResponseEntity<EmpDTO> getById(@PathVariable Long idEmp){
        Optional<EmpDTO> emprestimoDTOOptional = empService.getById(idEmp);
        if(emprestimoDTOOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmpDTO> create(@RequestBody EmpDTO emprestimoDTO){
        EmpDTO emprestimoDTOSave = empService.create(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoDTOSave);
    }

    @PutMapping("/{idEmp}")
    public ResponseEntity<EmpDTO> update(@PathVariable Long idEmp, @RequestBody EmpDTO emprestimoDTO){
        Optional<EmpDTO> emprestimoDTOOptional = empService.update(idEmp, emprestimoDTO);
        if(emprestimoDTOOptional.isPresent()){
            return ResponseEntity.ok(emprestimoDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idEmp}")
    public ResponseEntity<Void> delete(@PathVariable Long idEmp){
        if(empService.delete(idEmp)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
