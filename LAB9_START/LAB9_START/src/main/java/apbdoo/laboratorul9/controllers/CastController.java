package apbdoo.laboratorul9.controllers;

import apbdoo.laboratorul9.domain.Cast;
import apbdoo.laboratorul9.domain.Film;
import apbdoo.laboratorul9.domain.InfoActor;
import apbdoo.laboratorul9.services.CastService;
import apbdoo.laboratorul9.services.FilmService;
import apbdoo.laboratorul9.services.InfoActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CastController {
    FilmService filmService;
    CastService castService;
    InfoActorService infoActorService;

    public CastController(FilmService filmService, CastService castService,
                          InfoActorService infoActorService) {
        this.filmService = filmService;
        this.castService = castService;
        this.infoActorService = infoActorService;
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


    @GetMapping("film/{filmId}/cast/new")
    public String newCast(@PathVariable String filmId, Model model){
        Film film = filmService.findById(Long.valueOf(filmId));
        Cast cast = new Cast();
        cast.setFilm(film);

        model.addAttribute("cast", cast);
        cast.setInfoActor(new InfoActor());

        model.addAttribute("infoActorList",  infoActorService.listAllActors());
        return "cast/castform";
    }

    @GetMapping("film/{filmId}/cast/{id}/update")
    public String updateCastIngredient(@PathVariable String filmId,
                                         @PathVariable String id, Model model){
        model.addAttribute("cast", castService.findByFilmIdAndCastId(Long.valueOf(filmId), Long.valueOf(id)));

        model.addAttribute("infoActorList", infoActorService.listAllActors());
        return "cast/castform";
    }

    @PostMapping("film/{filmId}/cast")
    public String saveOrUpdate(@ModelAttribute Cast cast){

        Cast savedCast = castService.saveCast(cast);
        return "redirect:/film/" + savedCast.getFilm().getId() + "/cast/" + savedCast.getId() + "/show";
    }


    @GetMapping("film/{filmId}/cast/{id}/delete")
    public String deleteCast(@PathVariable String filmId,
                             @PathVariable String id){
        castService.deleteById(Long.valueOf(filmId), Long.valueOf(id));

        return "redirect:/film/" + filmId + "/cast";
    }



}
