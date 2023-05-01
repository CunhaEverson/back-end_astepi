package com.api.astepi.dtos;


import com.api.astepi.models.AgendamentoModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

public class PessoaDto {
    @JsonIgnoreProperties(ignoreUnknown = true) //validações para verificar se não estar vindo null ou número vázio.
    private String nome;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cpf;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String celular;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String email;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String matricula;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String cargo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String nomeLogin;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String senha;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
