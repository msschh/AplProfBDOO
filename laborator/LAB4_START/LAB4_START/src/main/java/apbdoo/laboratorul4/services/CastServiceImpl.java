package apbdoo.laboratorul4.services;

import apbdoo.laboratorul4.domain.Cast;
import apbdoo.laboratorul4.domain.Film;
import apbdoo.laboratorul4.repositories.FilmRepository;
import apbdoo.laboratorul4.repositories.InfoActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CastServiceImpl implements CastService {
    FilmRepository filmRepository;
    InfoActorRepository infoActorRepository;

    public CastServiceImpl(FilmRepository filmRepository, InfoActorRepository infoActorRepository) {
        this.filmRepository = filmRepository;
        this.infoActorRepository = infoActorRepository;
    }

    @Override
    public Cast findByFilmIdAndCastId(Long filmId, Long castId) {
        Optional<Film> filmOptional = filmRepository.findById(filmId);
        Film film;
        Cast cast = null;
        if (filmOptional.isPresent()) {
            film = filmOptional.get();
            for (Cast c : film.getCast()) {
                if (c.getId() == castId)
                    cast = c;
            }
        }
        else{
            log.error("film id not found. Id: " + filmId);
        }
        return cast;
    }

    @Override
    public Cast saveCast(Cast cast) {
        Optional<Film> filmOptional = filmRepository.findById(cast.getFilm().getId());

        if(!filmOptional.isPresent()){
            log.error("film not found. Id: " + cast.getFilm().getId());
            return new Cast();
        } else {
            Film film = filmOptional.get();

            Optional<Cast> castOptional = film.getCast().stream()
                    .filter(c -> c.getId().equals(cast.getId()))
                    .findFirst();


            if(castOptional.isPresent()){
                Cast castToSave = castOptional.get();
                castToSave.setRol(cast.getRol());
                castToSave.setInfoActor(infoActorRepository
                        .findById(cast.getInfoActor().getId())
                        .orElseThrow(() -> new RuntimeException("ACTOR NOT FOUND")));
            } else {
                Cast castToSave = new Cast();
                castToSave.setFilm(film);
                castToSave.setInfoActor(infoActorRepository
                        .findById(cast.getInfoActor().getId())
                        .orElseThrow(() -> new RuntimeException("ACTOR NOT FOUND")));
                castToSave.setRol(cast.getRol());
                film.addCast(castToSave);
            }

            Film savedFilm = filmRepository.save(film);

            Optional<Cast> savedCastOptional = savedFilm.getCast().stream()
                    .filter(c -> c.getId().equals(cast.getId()))
                    .findFirst();


            if(!savedCastOptional.isPresent()){

                savedCastOptional = savedFilm.getCast().stream()
                        .filter(c -> c.getRol().equals(cast.getRol()))
                        .filter(c -> c.getInfoActor().getId().equals(cast.getInfoActor().getId()))
                        .findFirst();
            }


            return savedCastOptional.get();
        }

    }

    @Override
    public void deleteById(Long filmId, Long castId) {
        Optional<Film> filmOptional = filmRepository.findById(filmId);

        if (filmOptional.isPresent()) {
            Film film = filmOptional.get();

            Optional<Cast> castOptional = film.getCast().stream()
                    .filter(c -> c.getId().equals(castId))
                    .findFirst();


            if(castOptional.isPresent()){
                Cast castToDelete = castOptional.get();
                castToDelete.setFilm(null);
                film.getCast().remove(castOptional.get());
                filmRepository.save(film);
            }
        } else {
            log.debug("Film Id Not found. Id:" + filmId);
        }
    }
}
