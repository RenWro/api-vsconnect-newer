package com.senai.apivsconnect.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_servico")
public class ServicoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String titulo;
    private String descricao;
    private BigDecimal proposta;
    private String status_servico;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private UsuarioModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_dev", referencedColumnName = "id")
    private UsuarioModel dev;
}
