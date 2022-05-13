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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUsers")
    private List<User> usersGetAlerts = new ArrayList<User>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUsers")
    private List<User> usersSendAlerts = new ArrayList<User>();

    public Long getIdAlertes() {
        return idAlertes;
    }

    public void setIdAlertes(Long idAlertes) {
        this.idAlertes = idAlertes;
    }

    public List<User> getUsersGetAlerts() {
        return usersGetAlerts;
    }

    public void setUsersGetAlerts(List<User> usersGetAlerts) {
        this.usersGetAlerts = usersGetAlerts;
    }

    public List<User> getUsersSendAlerts() {
        return usersSendAlerts;
    }

    public void setUsersSendAlerts(List<User> usersSendAlerts) {
        this.usersSendAlerts = usersSendAlerts;
    }
}
