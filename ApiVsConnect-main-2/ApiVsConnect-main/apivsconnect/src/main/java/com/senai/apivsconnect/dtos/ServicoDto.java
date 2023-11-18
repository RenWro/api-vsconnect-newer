package com.senai.apivsconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ServicoDto(
        @NotBlank String titulo,
        String descricao,
        BigDecimal proposta,
        String status_servico,
        @NotNull UUID id_cliente,
        UUID id_dev
        ) {}
