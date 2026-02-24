package com.tp4;

import com.tp4.ihm.TestBanque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-banque");
        EntityManager em = emf.createEntityManager();

        TestBanque test = new TestBanque();

        try {
            test.insererDonnees(em);
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
