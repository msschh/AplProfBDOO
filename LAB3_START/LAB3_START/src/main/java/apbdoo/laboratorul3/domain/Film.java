package apbdoo.laboratorul3.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titlu;
    private Integer minute;
    private String urlTrailer;

    @Lob
    private Byte[] imagine;

    @OneToOne(cascade = CascadeType.ALL)
    private Info info;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<Cast> cast = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Audienta audienta;

    @ManyToMany
    @JoinTable(name = "film_categorie",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private Set<Categorie> categorii = new HashSet<>();

    public Set<Categorie> getCategorii() {
        return categorii;
    }

    public void setCategorii(Set<Categorie> categorii) {
        this.categorii = categorii;
    }

    public Set<Cast> getCast() {
        return cast;
    }

    public void setCast(Set<Cast> cast) {
        this.cast = cast;
    }

    public Audienta getAudienta() {
        return audienta;
    }

    public void setAudienta(Audienta audienta) {
        this.audienta = audienta;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }

    public Byte[] getImagine() {
        return imagine;
    }

    public void setImagine(Byte[] imagine) {
        this.imagine = imagine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
