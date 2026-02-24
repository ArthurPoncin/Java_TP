package com.tp4.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {

    @Column(name = "taux")
    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, Client client, Banque banque, double taux) {
        super(numero, solde, client, banque);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA [" + super.toString() + ", taux=" + taux + "]";
    }
}
