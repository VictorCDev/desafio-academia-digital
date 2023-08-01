package me.dio.academia.academiadigital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    private String nome;

    private String cpf;

    private String bairro;

    private String dataDeNascimento;
}
