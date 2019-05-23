package apbdoo.laboratorul6.services;

import apbdoo.laboratorul6.domain.Film;

import java.util.Set;

public interface FilmService {
    Set<Film> getFilme();

    Film findById(Long l);

    Film saveFilm(Film film);

    void deleteById(Long id);
}
