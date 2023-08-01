package me.dio.academia.academiadigital.service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.AvaliacaoFisica;
import me.dio.academia.academiadigital.entity.form.AlunoForm;
import me.dio.academia.academiadigital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.academiadigital.reposity.AlunoRepository;
import me.dio.academia.academiadigital.reposity.AvaliacaoFisicaRepository;
import me.dio.academia.academiadigital.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;

    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {

        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisica findById(Long id) {
        Optional<AvaliacaoFisica> obj = avaliacaoFisicaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public AvaliacaoFisica update(Long id, AvaliacaoFisicaForm obj) {

        AvaliacaoFisica newObj = findById(id);
        newObj.setPeso(obj.getPeso());
        newObj.setAltura(obj.getAltura());
        return avaliacaoFisicaRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        avaliacaoFisicaRepository.deleteById(id);
    }
}
