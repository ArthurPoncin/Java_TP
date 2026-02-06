package com.tp2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.tp2.ihm.TestBibliotheque;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-tp2");
        EntityManager em = emf.createEntityManager();

        TestBibliotheque bibliotheque = new TestBibliotheque();

        try {
            bibliotheque.afficherEmpruntEtLivre(em, 1);
            bibliotheque.afficherEmpruntsDuClient(em, 1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em.isOpen())
                em.close();
            if (emf.isOpen())
                emf.close();
        }
    }
}
