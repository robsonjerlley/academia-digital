package me.dio.academia.digital.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import me.dio.academia.digital.entity.enums.Role;

import java.util.Objects;

public class UsuarioForm {
    @NotBlank(message = "O nome de usuário não pode estar em branco.")
    private  String username;
    @NotBlank(message = "A senha não pode estar em branco.")
    private String password;
    @NotNull(message =  "A role (perfil) do usuário é obrigatória.")
    private Role role;


    public UsuarioForm() {
    }

    public UsuarioForm(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
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
        UsuarioForm that = (UsuarioForm) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }

    @Override
    public String toString() {
        return "UsuarioForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
