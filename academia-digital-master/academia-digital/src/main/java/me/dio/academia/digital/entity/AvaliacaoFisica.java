package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_avaliacao_fisica")
public class AvaliacaoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @Column(name = "peso_atual")
    private Double peso;

    @Column(name = "altura_atual")
    private Double altura;

    public AvaliacaoFisica() {
    }


    public AvaliacaoFisica(Long id, Aluno aluno, LocalDateTime dataAvaliacao, Double peso, Double altura) {
        this.id = id;
        this.aluno = aluno;
        this.dataAvaliacao = dataAvaliacao;
        this.peso = peso;
        this.altura = altura;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisica that = (AvaliacaoFisica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}


