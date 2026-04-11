package sn.isi.master2026;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.isi.master2026.model.Assurance;
import sn.isi.master2026.model.Type;
import sn.isi.master2026.repository.AssuranceRepository;
import sn.isi.master2026.utils.JpaUtil;

import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) {
        AssuranceRepository assuranceRepository = new AssuranceRepository();


       // assuranceRepository.add(assurance);

       /* assuranceRepository.getAll().forEach(
                assurance -> System.out.println(assurance.toString())
        );*/
        Assurance assurance=  assuranceRepository.getById(3);

        assurance.setNomClient("Abdou diouf");
        assurance.setNumero("111111111111111");

        assuranceRepository.update(assurance);
    }
}
