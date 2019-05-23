package apbdoo.laboratorul3.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String denumire;

    @ManyToMany(mappedBy = "categorii")
    private Set<Film> film = new HashSet<>();

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}
