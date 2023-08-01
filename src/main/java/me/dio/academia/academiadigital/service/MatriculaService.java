package me.dio.academia.academiadigital.service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.Matricula;
import me.dio.academia.academiadigital.entity.form.MatriculaForm;
import me.dio.academia.academiadigital.reposity.AlunoRepository;
import me.dio.academia.academiadigital.reposity.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    public Matricula create(MatriculaForm form){

        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);

    }

    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

}