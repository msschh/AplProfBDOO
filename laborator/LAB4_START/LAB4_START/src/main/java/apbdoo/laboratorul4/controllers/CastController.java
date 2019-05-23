package apbdoo.laboratorul4.controllers;

import apbdoo.laboratorul4.services.CastService;
import apbdoo.laboratorul4.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CastController {

    private final FilmService filmService;
    private final CastService castService;

    public CastController(FilmService filmService, CastService castService) {
        this.filmService = filmService;
        this.castService = castService;
    }

    @GetMapping("/film/{filmId}/cast")
    public String listCast(@PathVariable String filmId, Model model){
        model.addAttribute("film", filmService.findById(Long.valueOf(filmId)));
        return "cast/list";
    }

    @GetMapping("film/{filmId}/cast/{id}/show")
    public String showFilmCast(@PathVariable String filmId,
                               @PathVariable String id, Model model){
        model.addAttribute("cast", castService.findByFilmIdAndCastId(Long.valueOf(filmId), Long.valueOf(id)));
        return "cast/show";
    }

}
