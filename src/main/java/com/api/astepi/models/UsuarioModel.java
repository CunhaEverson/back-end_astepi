package com.api.astepi.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="USUARIOMODEL")
public class UsuarioModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 11;


    @Column(length = 10)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataNascimento;

    @Column(length = 50)
    private String profissao;

    @Column(length =25)
    private boolean estadoCivil;

    @Column(length = 25)
    private String nacionalidade;

    @Column(length = 25)
    private String naturalidade;


    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioEndereco")
    private List<EnderecoModel> endereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioAgendamento")
    private List<AgendamentoModel> agendamento;*/

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) //atualizado
    private List<AgendamentoModel> agendamentos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) //atualizado
    private List<EnderecoModel> enderecos = new ArrayList<>();

    // Podemos criar outros métodos de acordo com a lógica de negócio do projeto
    public void addAgendamento(AgendamentoModel agendamento) {
        agendamentos.add(agendamento);
        agendamento.setUsuario(this);
    }

    public void removeAgendamento(AgendamentoModel agendamento) {
        agendamentos.remove(agendamento);
        agendamento.setUsuario(null);
    }

    public void addEndereco(EnderecoModel endereco) {
        enderecos.add(endereco);
        endereco.setUsuario(this);
    }

    public void removeEndereco(EnderecoModel endereco) {
        enderecos.remove(endereco);
        endereco.setUsuario(null);
    }



    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuarioFormulario")
    private FormularioModel formulario;

    @ManyToOne
    @JoinColumn(name = "administrador_usuario_id")
    private AdministradorModel administradorUsuario;


    /*
        public UsuarioModel() {
        }

        public UsuarioModel(UUID id, String nome, String cpf, int celular, String email, int matricula, String cargo, boolean status, String nomeLogin, String senha, LocalDateTime registrationDate, List<AgendamentoModel> agendamento){
            super(id, nome, cpf, celular, email, matricula, cargo, status, nomeLogin, senha, registrationDate);
        }
    */
    public AdministradorModel getAdministradorUsuario() {
        return administradorUsuario;
    }

    public void setAdministradorUsuario(AdministradorModel administradorUsuario) {
        this.administradorUsuario = administradorUsuario;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean isEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }


    public FormularioModel getFormulario() {
        return formulario;
    }

    public void setFormulario(FormularioModel formulario) {
        this.formulario = formulario;
    }

    public List<AgendamentoModel> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoModel> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }
}
