package apbdoo.laboratorul4.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denumire;

    @ManyToMany(mappedBy = "categorii")
    private Set<Film> filme = new HashSet<Film>();

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

    public Set<Film> getFilme() {
        return filme;
    }

    public void setFilme(Set<Film> filme) {
        this.filme = filme;
    }
}
