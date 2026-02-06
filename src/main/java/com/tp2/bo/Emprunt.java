package com.tp2.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "delai", nullable = true)
    private Integer delai;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = true)
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id"))
    private Set<Livre> livres;

    public Emprunt() {
    }

    public Emprunt(Integer delai, LocalDate dateDebut, LocalDate dateFin, Client client, Set<Livre> livres) {
        this.delai = delai;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.livres = livres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt [id=" + id + ", delai=" + delai + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
                + ", client=" + client + ", livres=" + livres + "]";
    }

}
