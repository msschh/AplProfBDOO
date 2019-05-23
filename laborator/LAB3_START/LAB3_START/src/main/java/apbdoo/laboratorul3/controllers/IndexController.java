package apbdoo.laboratorul3.controllers;

import apbdoo.laboratorul3.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @Autowired
    private FilmService filmService;

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
