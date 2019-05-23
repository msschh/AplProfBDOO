package apbdoo.laboratorul9.controllers;

import apbdoo.laboratorul9.domain.Film;
import apbdoo.laboratorul9.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping("/film/info/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("film", filmService.findById(new Long(id)));

        return "info";
    }

    @RequestMapping("/film/new")
    public String newFilm(Model model){
        model.addAttribute("film", new Film());

        return "new";
    }

    @PostMapping("film")
    public String saveOrUpdate(@Valid @ModelAttribute Film film,
                               BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "new";
        }
        Film savedCommand = filmService.saveFilm(film);

        //return "redirect:/film/info/" + film.getId();
        return "redirect:/filme" ;
    }

    @GetMapping
    @RequestMapping("film/{id}/delete")
    public String deleteById(@PathVariable String id){

        filmService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
