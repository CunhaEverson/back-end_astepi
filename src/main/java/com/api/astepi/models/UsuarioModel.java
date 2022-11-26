package com.api.astepi.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 11;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private Date dataNascimento;

    @Column(nullable = false, unique = true, length = 50)
    private String profissao;

    @Column(nullable = false, unique = true, length =25)
    private boolean estadoCivil;

    @Column(nullable = false, unique = true, length = 25)
    private String nacionalidade;

    @Column(nullable = false, unique = true, length = 25)
    private String naturalidade;

    @JoinColumn(nullable = false, unique = true)
    @ManyToOne
    FormularioModel formularioModel;



    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
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


}
