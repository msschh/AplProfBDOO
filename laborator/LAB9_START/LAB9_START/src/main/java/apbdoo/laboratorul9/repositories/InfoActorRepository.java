package apbdoo.laboratorul9.repositories;

import apbdoo.laboratorul9.domain.InfoActor;
import org.springframework.data.repository.CrudRepository;

public interface InfoActorRepository extends CrudRepository<InfoActor, Long> {
    InfoActor findByNume(String nume);
}
