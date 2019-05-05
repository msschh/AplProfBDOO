package apbdoo.laboratorul6.repositories;

import apbdoo.laboratorul6.domain.InfoActor;
import org.springframework.data.repository.CrudRepository;

public interface InfoActorRepository extends CrudRepository<InfoActor, Long> {
    InfoActor findByNume(String nume);
}
