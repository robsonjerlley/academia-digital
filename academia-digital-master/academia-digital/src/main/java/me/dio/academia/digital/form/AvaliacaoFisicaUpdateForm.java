package me.dio.academia.digital.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class AvaliacaoFisicaUpdateForm {

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O número presica ser positivo")
    private Double peso;

    @NotNull(message = "Preencha o campo corretamente")
    @Positive(message = "O número presica ser positivo")
    private Double altura;

    public AvaliacaoFisicaUpdateForm() {
    }


    public AvaliacaoFisicaUpdateForm(Double peso, Double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }


}
