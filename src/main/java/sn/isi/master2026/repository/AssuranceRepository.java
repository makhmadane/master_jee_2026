package sn.isi.master2026.repository;

import jakarta.persistence.EntityManager;
import sn.isi.master2026.model.Assurance;
import sn.isi.master2026.utils.JpaUtil;
import java.util.List;

public class AssuranceRepository {

    private EntityManager db;

    public AssuranceRepository(){
        this.db = JpaUtil.getEntityManager();
    }

    public void add(Assurance assurance){
        this.db.getTransaction().begin();
        this.db.persist(assurance);
        this.db.getTransaction().commit();
    }

    public Assurance getById(int id){
        return db.find(Assurance.class,id);
    }

    public void update(Assurance assurance){
        this.db.getTransaction().begin();
        this.db.merge(assurance);
        this.db.getTransaction().commit();
    }

    public void delete(int id){
        this.db.getTransaction().begin();
        this.db.remove(getById(id));
        this.db.getTransaction().commit();
    }


    public List<Assurance> getAll(){
        return  this.db.createQuery("SELECT a FROM Assurance a ").getResultList();  //JPQL //SQL
    }
}
