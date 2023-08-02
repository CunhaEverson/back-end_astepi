package com.api.astepi.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

public class SecretariaDto {

    @JsonIgnoreProperties(ignoreUnknown = true) //Atualizado
    private UUID agendamentoId;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public UUID getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(UUID agendamentoId) {
        this.agendamentoId = agendamentoId;
    }
}
