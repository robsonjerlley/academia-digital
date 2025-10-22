package me.dio.academia.digital.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import me.dio.academia.digital.entity.enums.Role;

import java.util.Objects;

public class UsuarioDTO {
    @NotNull(message = "Preencha o campo corretamente.")
    @Positive
    private Long id;
    @NotNull(message = "Preencha o campo corretamente.")
    private String username;
    @NotBlank(message = "O campo é obrigatório, preencha sem espaços.")
    private String password;
    @NotBlank(message = "Preencha o campo corretamente, o campo é obrigatório.")
    private Role role;

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
