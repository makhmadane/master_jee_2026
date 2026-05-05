package sn.isi.master2026.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(nullable = false,length = 50,unique = true)
    private String label;

    private LocalDate dateCreation;

    @ToString.Exclude
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Assurance>  assurances ;
}
