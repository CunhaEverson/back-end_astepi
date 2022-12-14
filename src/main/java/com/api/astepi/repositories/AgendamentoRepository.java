package com.api.astepi.repositories;

import com.api.astepi.models.AgendamentoModel;
import com.api.astepi.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, UUID> {

}
