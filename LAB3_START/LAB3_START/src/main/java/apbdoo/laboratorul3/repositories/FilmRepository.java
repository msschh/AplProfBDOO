package apbdoo.laboratorul3.repositories;

import apbdoo.laboratorul3.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
