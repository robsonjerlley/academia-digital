package me.dio.academia.digital.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;
import java.util.Objects;


public class AlunoForm {

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 150, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres")
    private String name;

    @NotEmpty(message = "Preencha o campo corretamente")
    @CPF(message = "'${validateValue}' é invalido!")
    private String cpf;

    @NotEmpty(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validateValue}' precisa estar entre {min} e {max} caracteres" )
    private String bairro;

    @NotNull(message = "Preencha o campo corretamente")
    @Past(message = "Data: '${validateValue}' é inválida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public AlunoForm() {
    }

    public AlunoForm(String name, String cpf, String bairro, LocalDate dataNascimento) {
        this.name = name;
        this.cpf = cpf;
        this.bairro = bairro;
        this.dataNascimento = dataNascimento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoForm alunoForm = (AlunoForm) o;
        return Objects.equals(cpf, alunoForm.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
