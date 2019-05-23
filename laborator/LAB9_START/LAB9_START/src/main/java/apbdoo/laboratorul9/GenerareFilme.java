package apbdoo.laboratorul9;

import apbdoo.laboratorul9.domain.*;
import apbdoo.laboratorul9.repositories.CategorieRepository;
import apbdoo.laboratorul9.repositories.FilmRepository;
import apbdoo.laboratorul9.repositories.InfoActorRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenerareFilme implements ApplicationListener<ContextRefreshedEvent> {
    private final FilmRepository filmRepository;
    private final InfoActorRepository infoActorRepository;
    private final CategorieRepository categorieRepository;

    public GenerareFilme(FilmRepository filmRepository, InfoActorRepository infoActorRepository, CategorieRepository categorieRepository) {
        this.filmRepository = filmRepository;
        this.infoActorRepository = infoActorRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        filmRepository.saveAll(getFilme());
    }

    private List<Film> getFilme(){
        List<Film> filme = new ArrayList<Film>();
        Film film = new Film();
        film.setAudienta(Audienta.AG);
        film.setMinute(120);
        film.setTitlu("Aquaman");


        Info info = new Info();
        info.setInfo("Arthur Curry learns that" +
                " he is the heir to the underwater " +
                "kingdom of Atlantis, and must step " +
                "forward to lead his people and be a hero " +
                "to the world.");
        film.setInfo(info);

        Categorie categorie = categorieRepository.findByDenumire("fantasy");
        film.getCategorii().add(categorie);
        categorie = categorieRepository.findByDenumire("comedie");
        film.getCategorii().add(categorie);

        InfoActor infoActor = infoActorRepository.findByNume("Jason Momoa");
        Cast cast = new Cast();
        cast.setInfoActor(infoActor);
        cast.setRol("Arthur");
		film.addCast(cast);

		infoActor = infoActorRepository.findByNume("Amber Heard");
        cast = new Cast();
        cast.setInfoActor(infoActor);
        cast.setRol("Mera");

        film.addCast(cast);
		
        filme.add(film);


        return filme;
    }
}

