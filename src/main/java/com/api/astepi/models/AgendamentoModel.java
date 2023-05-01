package com.api.astepi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 2)
    private int dia;

    @Column(length = 2)
    private String mes;

    @Column(length = 4)
    private int ano;

    @Column(length = 4)
    private int horario;

    @Column(length = 255)
    private String sala;


    @ManyToMany(mappedBy = "agendamentos", cascade = { CascadeType.ALL })
    private Set<SecretariaModel> endereco= new HashSet<SecretariaModel>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "agendamento_endereco", joinColumns = {
                    @JoinColumn(name = "agendamento_id")}, inverseJoinColumns = {
                    @JoinColumn(name = "endereco_id")})
    Set<EnderecoModel> enderecos = new HashSet<EnderecoModel>();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agendamentoDocumento")
    private List<DocumentoModel> documento;



    @JsonIgnore                                 //Atualizado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;




/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioModel_id")
    private UsuarioModel usuarioModel;*/


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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


    public Set<SecretariaModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(Set<SecretariaModel> endereco) {
        this.endereco = endereco;
    }

    public Set<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    public List<DocumentoModel> getDocumento() {
        return documento;
    }

    public void setDocumento(List<DocumentoModel> documento) {
        this.documento = documento;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}

