package com.tp4.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {

    @Column(name = "adresse_numero")
    private int numero;

    @Column(name = "adresse_rue")
    private String rue;

    @Column(name = "adresse_code_postal")
    private int codePostal;

    @Column(name = "adresse_ville")
    private String ville;

    public Adresse() {
    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return numero + " " + rue + ", " + codePostal + " " + ville;
    }
}
