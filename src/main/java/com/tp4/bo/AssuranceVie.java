package com.tp4.bo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Compte {

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "taux")
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, double solde, Client client, Banque banque, LocalDate dateFin, double taux) {
        super(numero, solde, client, banque);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie [" + super.toString() + ", dateFin=" + dateFin + ", taux=" + taux + "]";
    }
}
