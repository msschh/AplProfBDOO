package apbdoo.laboratorul4.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String actor;
    private String rol;
    @OneToOne
    private InfoActor infoActor;
    @ManyToOne
    private Film film;


    public InfoActor getInfoActor() {
        return infoActor;
    }

    public void setInfoActor(InfoActor infoActor) {
        this.infoActor = infoActor;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    private BigDecimal nrEpisoade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public BigDecimal getNrEpisoade() {
        return nrEpisoade;
    }

    public void setNrEpisoade(BigDecimal nrEpisoade) {
        this.nrEpisoade = nrEpisoade;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


}
