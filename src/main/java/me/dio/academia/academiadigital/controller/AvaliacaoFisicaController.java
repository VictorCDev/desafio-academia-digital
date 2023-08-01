package me.dio.academia.academiadigital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.AvaliacaoFisica;
import me.dio.academia.academiadigital.entity.form.AlunoForm;
import me.dio.academia.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.academiadigital.service.AvaliacaoFisicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@Slf4j
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService service;

    @PostMapping("/create")
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @GetMapping("/find/{id}")
    public AvaliacaoFisica findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaForm obj) {
        AvaliacaoFisica newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
