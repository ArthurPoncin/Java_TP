package com.tp2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-tp2");
        EntityManager em = emf.createEntityManager();

        Livre l1 = em.find(Livre.class, 1);
        if (l1 != null) {
            System.out.println("Livre 1 trouvé : " + l1.getTitre() + " de " + l1.getAuteur());
        }

        em.getTransaction().begin();

        Livre newLivre = new Livre("L'Étranger", "Albert Camus");
        em.persist(newLivre);
        System.out.println("Nouveau livre inséré avec ID : " + newLivre.getId());

        Livre l5 = em.find(Livre.class, 5);
        if (l5 != null) {
            System.out.println("Ancien titre ID 5 : " + l5.getTitre());
            l5.setTitre("Du plaisir dans la cuisine");
            System.out.println("Nouveau titre ID 5 : " + l5.getTitre());
        }

        Livre lDel = em.find(Livre.class, 3);
        if (lDel != null) {
            em.remove(lDel);
            System.out.println("Livre ID 3 supprimé.");
        }

        em.getTransaction().commit();

        TypedQuery<Livre> qTitre = em.createQuery("SELECT l FROM Livre l WHERE l.titre = :t", Livre.class);
        qTitre.setParameter("t", "Germinal");
        List<Livre> resultTitre = qTitre.getResultList(); 
        if (!resultTitre.isEmpty()) {
            System.out.println("Trouvé : " + resultTitre.get(0));
        }

        TypedQuery<Livre> qAuteur = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = :a", Livre.class);
        qAuteur.setParameter("a", "Emile Zola");
        for (Livre l : qAuteur.getResultList()) {
            System.out.println(l);
        }

        TypedQuery<Livre> qAll = em.createQuery("SELECT l FROM Livre l", Livre.class);
        for (Livre l : qAll.getResultList()) {
            System.out.println(l);
        }

        em.close();
        emf.close();
    }
}
