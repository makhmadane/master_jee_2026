package sn.isi.master2026.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(name = "assurance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length =30, nullable = false)
    @NonNull
    private String nomClient;

    @Column(unique = true)
    @NonNull
    private String numero;

    private String cni;
    private LocalDate dateCreation;

    @Transient
    private int compteur;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_assurance_id",nullable = false)
    private Type type;


}
