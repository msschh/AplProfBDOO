package apbdoo.laboratorul6.repositories;

import apbdoo.laboratorul6.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
