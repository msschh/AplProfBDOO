package apbdoo.laboratorul6.repositories;

import apbdoo.laboratorul6.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Categorie findByDenumire(String denumire);
}
