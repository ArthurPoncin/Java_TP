package com.tp4.ihm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.tp4.bo.Adresse;
import com.tp4.bo.AssuranceVie;
import com.tp4.bo.Banque;
import com.tp4.bo.Client;
import com.tp4.bo.Compte;
import com.tp4.bo.LivretA;
import com.tp4.bo.Operation;
import com.tp4.bo.Virement;

import jakarta.persistence.EntityManager;

public class TestBanque {

    public void insererDonnees(EntityManager em) {
        em.getTransaction().begin();

        // Banque
        Banque bnp = new Banque("BNP Paribas");
        em.persist(bnp);

        Adresse adresse1 = new Adresse(12, "Rue de la Paix", 75001, "Paris");
        Client client1 = new Client("Dupont", "Alice", LocalDate.of(1990, 5, 14), adresse1);
        em.persist(client1);

        Adresse adresse2 = new Adresse(7, "Avenue Victor Hugo", 69002, "Lyon");
        Client client2 = new Client("Martin", "Bob", LocalDate.of(1985, 3, 22), adresse2);
        em.persist(client2);

        Compte compte1 = new Compte("FR76-0001", 1500.00, List.of(client1, client2), bnp);
        em.persist(compte1);

        LivretA livret = new LivretA("FR76-0002", 3000.00, List.of(client1), bnp, 3.0);
        em.persist(livret);

        AssuranceVie assurance = new AssuranceVie("FR76-0003", 10000.00, List.of(client1), bnp,
                LocalDate.of(2035, 1, 1), 2.5);
        em.persist(assurance);

        // Opérations
        Operation op1 = new Operation(LocalDateTime.of(2024, 1, 10, 9, 0), -50.00, "Courses", compte1);
        em.persist(op1);

        Operation op2 = new Operation(LocalDateTime.of(2024, 1, 15, 14, 30), 2000.00, "Salaire", compte1);
        em.persist(op2);

        Virement virement = new Virement(LocalDateTime.of(2024, 2, 1, 10, 0), -500.00, "Loyer", compte1,
                "Propriétaire SCI");
        em.persist(virement);

        em.getTransaction().commit();

        System.out.println("Données insérées avec succès !");
        System.out.println(bnp);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(compte1);
        System.out.println(livret);
        System.out.println(assurance);
    }
}
