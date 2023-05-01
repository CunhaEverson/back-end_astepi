package com.api.astepi.dtos;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;


public class AgendamentoDto {

    @JsonIgnoreProperties(ignoreUnknown = true) //Atualizado
    private UUID usuarioId;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int dia;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String mes;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int ano;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private int horario;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String sala;


    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    /*
    @JsonIgnoreProperties(ignoreUnknown = true)
    SecretariaDto secretariaDto;

    @JsonIgnoreProperties(ignoreUnknown = true)
    EnderecoDto enderecoDto;

    @JsonIgnoreProperties(ignoreUnknown = true)
    DocumentoDto documentoDto;*/

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }



}
