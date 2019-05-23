package apbdoo.laboratorul9.repositories;

import apbdoo.laboratorul9.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
