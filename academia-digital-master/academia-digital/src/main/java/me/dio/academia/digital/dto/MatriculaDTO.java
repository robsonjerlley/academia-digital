package me.dio.academia.digital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;

import java.time.LocalDateTime;
import java.util.Objects;


public class MatriculaDTO {

    private Long id;

    private AlunoDTO aluno;

    @JsonFormat(pattern = JavaTimeUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataMatricula;


    public MatriculaDTO() {
    }

    public MatriculaDTO(Long id, AlunoDTO aluno, LocalDateTime dataMatricula) {
        this.id = id;
        this.aluno = aluno;
        this.dataMatricula = dataMatricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public LocalDateTime getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDateTime dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaDTO that = (MatriculaDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MatriculaDTO{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", dataMatricula=" + dataMatricula +
                '}';
    }
}
