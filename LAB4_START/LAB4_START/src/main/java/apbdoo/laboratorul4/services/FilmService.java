package apbdoo.laboratorul4.services;

import apbdoo.laboratorul4.domain.Film;

import java.util.Set;

public interface FilmService {
    Set<Film> getFilme();

    Film findById(Long l);

    Film saveFilm(Film film);

    void deleteById(Long id);
}
