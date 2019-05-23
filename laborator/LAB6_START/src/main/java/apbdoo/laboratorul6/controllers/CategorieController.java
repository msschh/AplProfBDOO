package apbdoo.laboratorul6.controllers;

import apbdoo.laboratorul6.commands.CategorieCommand;
import apbdoo.laboratorul6.services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class CategorieController {
    CategorieService categorieService;

    @RequestMapping("categorie/new")
    public String newCategorie(Model model) {
        model.addAttribute("categorieCommand", new CategorieCommand());
        return "newcategorie";
    }

    @RequestMapping("categorie")
    public String saveCategorie(@Valid @ModelAttribute CategorieCommand categorieCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newcategorie";
        }
        categorieService.saveCategorieCommand(categorieCommand);
        return "redirect:/filme";
    }
}
