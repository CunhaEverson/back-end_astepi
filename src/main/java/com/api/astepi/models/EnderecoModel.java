package com.api.astepi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 254)
    private String rua;

    @Column(length = 15)
    private String numero;

    @Column(length = 254)
    private String complemento;

    @Column(length = 254)
    private String bairro;

    @Column(length = 254)
    private String cidade;

    @Column(length = 100)
    private String estado;

    @Column(length = 15)
    private String cep;

    public EnderecoModel(){  //Atualizado

    }

    //Atualizado
    public EnderecoModel(String rua, String numero, String cep, String complemento, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    /*@ManyToOne
    @JoinColumn(name = "usuario_endereco_id")
    private UsuarioModel usuarioEndereco;*/

    @JsonIgnore                                 //Atualizado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuario;

    @ManyToMany(mappedBy = "enderecos", cascade = { CascadeType.ALL })
    private Set<AgendamentoModel> agendamentos= new HashSet<AgendamentoModel>();

    @ManyToMany(mappedBy = "enderecos", cascade = { CascadeType.ALL })
    private Set<AdvogadoVoluntarioModel> advogadosvoluntarios = new HashSet<AdvogadoVoluntarioModel>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Set<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Set<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Set<AdvogadoVoluntarioModel> getAdvogadosvoluntarios() {
        return advogadosvoluntarios;
    }

    public void setAdvogadosvoluntarios(Set<AdvogadoVoluntarioModel> advogadosvoluntarios) {
        this.advogadosvoluntarios = advogadosvoluntarios;
    }

   /* public boolean comprovanteResid() {
        String entregue = "N";
        if (entregue == "S") {
            return true;
        } else {
            return false;
        }
    }*/

}
