package apbdoo.project.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Drept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cod;
    private String entitate;

    @ManyToMany(mappedBy = "drepturi")
    private Set<Rol> roluri = new HashSet<>();

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

    public String getEntitate() {
        return entitate;
    }

    public void setEntitate(String entitate) {
        this.entitate = entitate;
    }

    public Set<Rol> getRoluri() {
        return roluri;
    }

    public void setRoluri(Set<Rol> roluri) {
        this.roluri = roluri;
    }
}
