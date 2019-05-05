package apbdoo.laboratorul6.services;

import apbdoo.laboratorul6.domain.Cast;

public interface CastService {
    Cast findByFilmIdAndCastId(Long filmId, Long castId);
    Cast saveCast(Cast cast);
    void deleteById(Long filmId, Long castId);
}
