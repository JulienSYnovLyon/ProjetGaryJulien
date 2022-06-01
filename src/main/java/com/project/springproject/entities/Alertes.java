package com.project.springproject.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Alertes")
public class Alertes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @NotNull
    @NotBlank
    private Long idAlertes;

    @ManyToOne
    @JoinColumn(name = "idAnnonces")
    private Annonces annonces;

    @ManyToOne
    @JoinColumn(name = "idUsers1")
    private User users1;

    @ManyToOne
    @JoinColumn(name = "idUsers2")
    private User users2;

    public Long getIdAlertes() {
        return idAlertes;
    }

    public void setIdAlertes(Long idAlertes) {
        this.idAlertes = idAlertes;
    }

    public Annonces getAnnonces() {
        return annonces;
    }

    public void setAnnonces(Annonces annonces) {
        this.annonces = annonces;
    }

    public User getUsers2() {
        return users2;
    }

    public void setUsers2(User users2) {
        this.users2 = users2;
    }

    public User getUsers1() {
        return users1;
    }

    public void setUsers1(User users1) {
        this.users1 = users1;
    }
}
