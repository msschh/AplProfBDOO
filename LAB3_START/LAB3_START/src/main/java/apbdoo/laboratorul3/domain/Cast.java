package apbdoo.laboratorul3.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cast {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String actor;
	private BigDecimal nrEpisoade;
	private String rol;

	@ManyToOne
	private Film film;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
