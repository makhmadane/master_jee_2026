package sn.isi.master2026.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Columns;

import java.util.List;

@Entity
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

    @ToString.Exclude
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Assurance>  assurances ;
}
