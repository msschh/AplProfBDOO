package apbdoo.laboratorul9.services;

import apbdoo.laboratorul9.domain.Cast;

public interface CastService {
    Cast findByFilmIdAndCastId(Long filmId, Long castId);
    Cast saveCast(Cast cast);
    void deleteById(Long filmId, Long castId);
}
