package org.sid.entity;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    private Long id ;
    private String nom, prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNs;
    private String email;
    private long tel;
    private String photo;

    public Contact() {
    }

    public Contact( String nom, String prenom, Date dateNs, String email, long tel) {

        this.nom = nom;
        this.prenom = prenom;
        this.dateNs = dateNs;
        this.email = email;
        this.tel = tel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNs(Date dateNs) {
        this.dateNs = dateNs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {

        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNs() {
        return dateNs;
    }

    public String getEmail() {
        return email;
    }

    public long getTel() {
        return tel;
    }

    public String getPhoto() {
        return photo;
    }
}
