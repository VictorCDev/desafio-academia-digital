package me.dio.academia.academiadigital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.form.AlunoForm;
import me.dio.academia.academiadigital.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
@Slf4j
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping("/find/{id}")
    public Aluno findById(@PathVariable Long id ) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public Aluno create(@RequestBody AlunoForm form) {
        return service.create(form);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoForm obj) {
        Aluno newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
