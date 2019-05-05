package apbdoo.laboratorul9.repositories;

import apbdoo.laboratorul9.domain.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Categorie findByDenumire(String denumire);
}
