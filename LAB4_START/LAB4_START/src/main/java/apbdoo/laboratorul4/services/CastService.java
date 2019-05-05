package apbdoo.laboratorul4.services;

import apbdoo.laboratorul4.domain.Cast;

public interface CastService {
    Cast findByFilmIdAndCastId(Long filmId, Long castId);
    Cast saveCast(Cast cast);
    void deleteById(Long filmId, Long castId);
}
