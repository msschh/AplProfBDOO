package apbdoo.laboratorul4.repositories;

import apbdoo.laboratorul4.domain.InfoActor;
import org.springframework.data.repository.CrudRepository;

public interface InfoActorRepository extends CrudRepository<InfoActor, Long> {
    InfoActor findByNume(String nume);
}
