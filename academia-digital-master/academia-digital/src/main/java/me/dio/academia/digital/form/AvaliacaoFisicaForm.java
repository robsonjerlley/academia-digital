package me.dio.academia.digital.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class AvaliacaoFisicaForm {

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O ID deve ser positivo")
    private Long alunoId;



    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O número presica ser positivo")
    private double peso;

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O número presica ser positivo")
    private double altura;

    public AvaliacaoFisicaForm() {
    }

    public AvaliacaoFisicaForm(Long alunoId, double peso, double altura) {
        this.alunoId = alunoId;
        this.peso = peso;
        this.altura = altura;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisicaForm that = (AvaliacaoFisicaForm) o;
        return Objects.equals(alunoId, that.alunoId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(alunoId);
    }


}
