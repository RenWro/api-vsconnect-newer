package com.senai.apivsconnect.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_servicos")
public class ServicoModel implements Serializable {
    @Serial
    private static final long serialVersinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servico", nullable = false)
    private UUID id;

    private String titulo;
    private String descricao;
    private BigDecimal proposta;
    private String status_servico;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_usuario")
    private UsuarioModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_dev", referencedColumnName = "id_usuario")
    private UsuarioModel dev;
}