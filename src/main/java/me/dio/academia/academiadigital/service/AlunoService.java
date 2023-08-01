package me.dio.academia.academiadigital.service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.academiadigital.entity.Aluno;
import me.dio.academia.academiadigital.entity.AvaliacaoFisica;
import me.dio.academia.academiadigital.entity.form.AlunoForm;
import me.dio.academia.academiadigital.reposity.AlunoRepository;
import me.dio.academia.academiadigital.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno create(AlunoForm form) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        //convert String to LocalDate
        LocalDate dataNascimento = LocalDate.parse(form.getDataDeNascimento(), formatter);

        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(dataNascimento);

        return alunoRepository.save(aluno);

    }

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public Aluno update(Long id, AlunoForm obj) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        //convert String to LocalDate
        LocalDate dataDeNascimento = LocalDate.parse(obj.getDataDeNascimento(), formatter);

        Aluno newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setBairro(obj.getBairro());
        newObj.setDataDeNascimento(dataDeNascimento);
        return alunoRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        alunoRepository.deleteById(id);
    }
}
