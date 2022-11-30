package com.api.astepi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FORMULARIO")
public class FormularioModel implements Serializable {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    UsuarioModel usuarioModel;

    @Column(nullable = false, unique = true, length = 255)
    SecretariaModel secretariaModel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioModel_id")
    private UsuarioModel usuario;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public SecretariaModel getSecretariaModel() {
        return secretariaModel;
    }

    public void setSecretariaModel(SecretariaModel secretariaModel) {
        this.secretariaModel = secretariaModel;
    }
}
