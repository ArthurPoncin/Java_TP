package com.tp2.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "auteur", nullable = false, length = 50)
    private String auteur;

    public Livre() {
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
    }
}
