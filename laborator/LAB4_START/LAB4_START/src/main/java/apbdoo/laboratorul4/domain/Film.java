package apbdoo.laboratorul4.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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


    public Audienta getAudienta() {
        return audienta;
    }

    public void setAudienta(Audienta audienta) {
        this.audienta = audienta;
    }

    public Set<Cast> getCast() {
        return cast;
    }

    public void setCast(Set<Cast> cast) {
        this.cast = cast;
    }


    public Set<Categorie> getCategorii() {
        return categorii;
    }

    public void setCategorii(Set<Categorie> categorii) {
        this.categorii = categorii;
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
        info.setFilm(this);
    }





    public String getTitlu() {
        return titlu;
    }

    public Integer getMinute() {
        return minute;
    }

    public String getUrlTrailer() {
        return urlTrailer;
    }

    public Byte[] getImagine() {
        return imagine;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public void setUrlTrailer(String urlTrailer) {
        this.urlTrailer = urlTrailer;
    }

    public void setImagine(Byte[] imagine) {
        this.imagine = imagine;
    }

    public void addCast(Cast cast){
        this.cast.add(cast);
        cast.setFilm(this);
    }
}
