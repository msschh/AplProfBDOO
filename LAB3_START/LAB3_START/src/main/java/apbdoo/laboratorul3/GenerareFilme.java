package apbdoo.laboratorul3;

import apbdoo.laboratorul3.domain.Audienta;
import apbdoo.laboratorul3.domain.Categorie;
import apbdoo.laboratorul3.domain.Film;
import apbdoo.laboratorul3.repositories.CategorieRepository;
import apbdoo.laboratorul3.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class GenerareFilme implements ApplicationListener<ContextRefreshedEvent> {

    private final FilmRepository filmRepository;
    private final CategorieRepository categorieRepository;

    public GenerareFilme(FilmRepository filmRepository, CategorieRepository categorieRepository) {
        this.filmRepository = filmRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        filmRepository.saveAll(getFilme());
    }
    private List<Film> getFilme() {
        List<Film> filme = new ArrayList<>();
        Film film = new Film();
        film.setAudienta(Audienta.AP12);
        film.setMinute(121);
        film.setTitlu("Aquaman2");

        Categorie categorie = categorieRepository.findByDenumire("comedie");
        Set<Categorie> categorii = new HashSet<>();
        categorii.add(categorie);
        film.setCategorii(categorii);

        filme.add(film);
        return filme;
    }
}
