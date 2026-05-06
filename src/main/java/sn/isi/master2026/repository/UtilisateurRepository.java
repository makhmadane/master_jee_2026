package sn.isi.master2026.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import sn.isi.master2026.model.Utilisateur;
import sn.isi.master2026.utils.JpaUtil;

public class UtilisateurRepository {

    private EntityManager em() {
        return JpaUtil.getEntityManagerFactory().createEntityManager();
    }

    // Cherche un utilisateur par son login
    public Utilisateur findByLogin(String login) {
        EntityManager em = em();
        try {
            return em.createQuery(
                            "FROM Utilisateur u WHERE u.login = :login", Utilisateur.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;   // login introuvable → retourne null
        } finally {
            em.close();
        }
    }

    // Enregistre un nouvel utilisateur
    public void add(Utilisateur utilisateur) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(utilisateur);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

