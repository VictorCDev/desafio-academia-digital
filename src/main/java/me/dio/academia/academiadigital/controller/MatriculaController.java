package me.dio.academia.academiadigital.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.academia.academiadigital.entity.Matricula;
import me.dio.academia.academiadigital.entity.form.MatriculaForm;
import me.dio.academia.academiadigital.service.MatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
@Slf4j
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService service;

    @PostMapping("/create")
    public Matricula create(@RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<Matricula> getAll() {
        return service.getAll();
    }
}
