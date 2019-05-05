package apbdoo.laboratorul3.repositories;

import apbdoo.laboratorul3.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Categorie findByDenumire(String denumire);
}
