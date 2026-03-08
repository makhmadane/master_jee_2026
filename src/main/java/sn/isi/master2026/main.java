package sn.isi.master2026;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.isi.master2026.model.Assurance;
import sn.isi.master2026.utils.JpaUtil;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin(); //transaction

        Assurance assurance = new Assurance();
        assurance.setNomClient("moussa diop");
        assurance.setNumero("77302885");
        assurance.setCni("66666666666666");
        assurance.setDateCreation(LocalDate.now());
        em.persist(assurance);

        em.getTransaction().commit();//transaction


//        em.getTransaction().begin();
//        Assurance assurance = new Assurance();
//        assurance.setNomClient("moussa diop");
//        assurance.setNumero("77302885");
//        em.persist(assurance);
//        em.getTransaction().commit();
    }
}
