package me.dio.academia.digital.dto;


import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;


public class AvaliacaoFisicaDTO {

    private Long id;

    private Double peso;

    private Double altura;

    @JsonFormat(pattern = JavaTimeUtils.DATE_TIME_FORMAT)
    private LocalDateTime dataAvaliacao;

    public AvaliacaoFisicaDTO() {
    }

    public AvaliacaoFisicaDTO(Long id, Double peso, Double altura, LocalDateTime dataAvaliacao) {
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.dataAvaliacao = dataAvaliacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisicaDTO that = (AvaliacaoFisicaDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AvaliacaoFisicaDTO{" +
                "id=" + id +
                ", peso=" + peso +
                ", altura=" + altura +
                ", dataAvaliacao=" + dataAvaliacao +
                '}';
    }
}
