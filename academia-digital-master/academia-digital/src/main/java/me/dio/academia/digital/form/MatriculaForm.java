package me.dio.academia.digital.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class MatriculaForm {

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O ID deve ser positivo")
    private Long alunoId;

    public MatriculaForm() {
    }

    public MatriculaForm(Long alunoId) {
        this.alunoId = alunoId;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatriculaForm that = (MatriculaForm) o;
        return Objects.equals(alunoId, that.alunoId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alunoId);
    }
}
