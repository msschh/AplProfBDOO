package apbdoo.project.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cod;
    private String nume;
    private String descriere;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private Set<Utilizator> utilizatori = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "rol_drept",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "drept_id"))
    private Set<Drept> drepturi = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Set<Utilizator> getUtilizatori() {
        return utilizatori;
    }

    public void setUtilizatori(Set<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }

    public Set<Drept> getDrepturi() {
        return drepturi;
    }

    public void setDrepturi(Set<Drept> drepturi) {
        this.drepturi = drepturi;
    }
}
