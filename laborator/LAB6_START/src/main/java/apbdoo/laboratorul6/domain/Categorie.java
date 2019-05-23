package apbdoo.laboratorul6.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denumire;

    @ManyToMany(mappedBy = "categorii")
    private Set<Film> filme = new HashSet<Film>();


}
