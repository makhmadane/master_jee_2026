package sn.isi.master2026.repository;

import jakarta.persistence.EntityManager;
import sn.isi.master2026.model.Type;
import sn.isi.master2026.utils.JpaUtil;

import java.util.List;

public class TypeRepository {

    private EntityManager em() {
        return JpaUtil.getEntityManagerFactory().createEntityManager();
    }

    // Lire tous les types
    public List<Type> getAll() {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            List<Type> list =
                    em.createQuery("FROM Type ", Type.class).getResultList();
            em.getTransaction().commit();
            return list;
        } finally {
            em.close();  // toujours fermer !
        }
    }

    // Lire un type par son id
    public Type getById(int id) {
        EntityManager em = em();
        try {
            return em.find(Type.class, id);
        } finally {
            em.close();
        }
    }

    // Créer un nouveau type
    public void add(Type type) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.persist(type);  // INSERT INTO type (libelle) VALUES (...)
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Modifier un type existant
    public void update(Type type) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            em.merge(type);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Supprimer un type
    public void delete(int id) {
        EntityManager em = em();
        try {
            em.getTransaction().begin();
            Type type = em.find(Type.class, id);
            em.remove(type);  // DELETE FROM type WHERE id = ...
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

