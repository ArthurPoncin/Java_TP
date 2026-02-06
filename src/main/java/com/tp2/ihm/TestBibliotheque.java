package com.tp2.ihm;

import java.util.Set;

import com.tp2.bo.Client;
import com.tp2.bo.Emprunt;
import com.tp2.bo.Livre;

import jakarta.persistence.EntityManager;

public class TestBibliotheque {
    public void afficherEmpruntEtLivre(EntityManager em, int idEmprunt) {
        System.out.println("Requete : Emprunt n°" + idEmprunt);

        Emprunt emprunt = em.find(Emprunt.class, idEmprunt);

        if (emprunt != null) {
            System.out.println("Emprunt du " + emprunt.getDateDebut() + " par " + emprunt.getClient().getPrenom());
            System.out.println("Livres :");

            for (Livre l : emprunt.getLivres()) {
                System.out.println("Titre: " + l.getTitre() + " Auteur: " + l.getAuteur());
            }
        } else {
            System.out.println("Aucun Emprunt trouvé pour l'id : " + idEmprunt);
        }
    }

    public void afficherEmpruntsDuClient(EntityManager em, int idClient) {
        System.out.println("Requete: Emprunt du client n°:" + idClient);

        Client client = em.find(Client.class, idClient);

        if (client != null) {
            System.out.println("Client: " + client.getNom() + ", " + client.getPrenom());
            Set<Emprunt> emprunts = client.getEmprunts();

            if (emprunts.isEmpty()) {
                System.out.println("Le client " + client.getNom() + ", " + client.getPrenom() + " n'a rien emprunté");
            } else {
                for (Emprunt e : emprunts) {
                    System.out
                            .println("A emprunté le : " + e.getDateDebut() + " - " + e.getLivres().size() + " livres");
                }
            }
        } else {
            System.out.println("Aucun client avec cet Id: " + idClient);
        }
    }
}
