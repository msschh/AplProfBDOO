package apbdoo.laboratorul6.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlu;

    @Min(value=0, message = "min value 0")
    @Max(value=200, message = "max value 200")
    private Integer minute;

    private String urlTrailer;
    @Lob
    private Byte[] imagine;

    @Enumerated(value = EnumType.STRING)
    private Audienta audienta;


    @OneToOne(cascade = CascadeType.ALL)
    private Info info;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<Cast> cast = new HashSet<Cast>();

    @ManyToMany
    @JoinTable(name = "film_categorie",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Set<Categorie> categorii = new HashSet<Categorie>();



    public void setInfo(Info info) {
        this.info = info;
        info.setFilm(this);
    }


    public void addCast(Cast cast){
        this.cast.add(cast);
        cast.setFilm(this);
    }

}
