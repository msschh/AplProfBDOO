package apbdoo.laboratorul3.services;

import apbdoo.laboratorul3.domain.Film;
import apbdoo.laboratorul3.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FilmServiceImpl implements FilmService {
    FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Set<Film> getFilme() {
        Set<Film> filme = new HashSet<>();

        filmRepository.findAll().iterator().forEachRemaining(filme::add);
        return filme;
    }
}
