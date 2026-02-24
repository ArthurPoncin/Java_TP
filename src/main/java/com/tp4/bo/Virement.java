package com.tp4.bo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "virement")
public class Virement extends Operation {

    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(LocalDateTime date, double montant, String motif, Compte compte, String beneficiaire) {
        super(date, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement [" + super.toString() + ", beneficiaire=" + beneficiaire + "]";
    }
}
