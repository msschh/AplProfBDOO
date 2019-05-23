package apbdoo.laboratorul4.controllers;

import apbdoo.laboratorul4.services.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    private final FilmService filmService;

    public IndexController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping({"/filme"})
    public String getFilmePage(Model model){

        model.addAttribute("filme", filmService.getFilme());

        return "filme";
    }


}
