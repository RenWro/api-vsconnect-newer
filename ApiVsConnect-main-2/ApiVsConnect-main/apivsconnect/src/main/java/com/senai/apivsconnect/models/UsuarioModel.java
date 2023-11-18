package com.senai.apivsconnect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel implements Serializable, UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private UUID id;

    private String nome;
    private String email;

    @JsonIgnore
    private String senha;
    private String endereco;
    private String cep;

    private TipoModel tipo_usuario;
    private String url_img;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo_usuario == TipoModel.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_DESENVOLVEDOR"),
                    new SimpleGrantedAuthority("ROLE_CLIENTE")
            );
        } else if (this.tipo_usuario == TipoModel.DESENVOLVEDOR) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_DESENVOLVEDOR")
            );
        } else if (this.tipo_usuario == TipoModel.CLIENTE) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_CLIENTE")
            );
        }
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}