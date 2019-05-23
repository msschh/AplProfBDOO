package apbdoo.laboratorul4.repositories;

import apbdoo.laboratorul4.domain.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
}
