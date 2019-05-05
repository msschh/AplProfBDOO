package apbdoo.laboratorul6.services;

import apbdoo.laboratorul6.domain.Film;
import apbdoo.laboratorul6.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FilmServiceImpl implements FilmService{
    FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Set<Film> getFilme() {
        Set<Film> filme = new HashSet<Film>();
        filmRepository.findAll().iterator().forEachRemaining(filme::add);
        return filme;
    }

    @Override
    public Film findById(Long l) {

        Optional<Film> filmOptional = filmRepository.findById(l);

        if (!filmOptional.isPresent()) {
            throw new RuntimeException("Movie not found!");
        }

        return filmOptional.get();
    }


    @Override
    public Film saveFilm(Film film) {
        Film savedFilm = filmRepository.save(film);
        return savedFilm;
    }

    @Override
    public void deleteById(Long id) {
        filmRepository.deleteById(id);
    }
}
