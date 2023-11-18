package com.senai.apivsconnect.repositories;

import com.senai.apivsconnect.models.ServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<ServicoModel, UUID> {
}