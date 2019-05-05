package apbdoo.laboratorul4.repositories;

import apbdoo.laboratorul4.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Categorie findByDenumire(String denumire);
}
