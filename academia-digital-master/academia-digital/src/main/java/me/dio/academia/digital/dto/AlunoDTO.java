package me.dio.academia.digital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AlunoDTO {

    @NotNull(message = "Preencha o campo corretamente")
    @Positive
    private Long id;

    @NotNull(message = "Preencha o campo corretamente")
    private String name;
    @NotBlank(message = "Preencha o campo corretamente")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "DATA: '${validateValue}' é inválida")
    private LocalDate dataNascimento;

    private List<AvaliacaoFisicaDTO> avaliacoes;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String name, String cpf, LocalDate dataNascimento, List<AvaliacaoFisicaDTO> avaliacoes) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.avaliacoes = avaliacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<AvaliacaoFisicaDTO> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisicaDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlunoDTO alunoDTO = (AlunoDTO) o;
        return Objects.equals(id, alunoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
