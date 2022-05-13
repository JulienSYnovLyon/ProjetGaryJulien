package com.project.springproject.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Annonces")

public class Annonces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @NotNull
    @NotBlank
    private Long idAnnonces;

    @Column
    @NotNull
    @NotBlank
    private String Titre;

    @Lob
    @Column(columnDefinition = "TEXT")
    @NotNull
    @NotBlank
    private String Contenu;

    @Column
    private String Image;

    @Column
    @NotNull
    @NotBlank
    private String Prix;


    @ManyToOne
    @JoinColumn(name = "idType")
    private TypeAnnonce type;

    @ManyToOne
    @JoinColumn(name = "idUsers")
    private User user;

    public Long getIdAnnonces() {
        return idAnnonces;
    }

    public void setIdAnnonces(Long idAnnonces) {
        this.idAnnonces = idAnnonces;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String prix) {
        Prix = prix;
    }

    public TypeAnnonce getType() {
        return type;
    }

    public void setType(TypeAnnonce type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
