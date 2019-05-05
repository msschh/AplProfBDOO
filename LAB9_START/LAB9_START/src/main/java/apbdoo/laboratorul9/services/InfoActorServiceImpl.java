package apbdoo.laboratorul9.services;

import apbdoo.laboratorul9.domain.InfoActor;
import apbdoo.laboratorul9.repositories.InfoActorRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InfoActorServiceImpl implements InfoActorService{
    InfoActorRepository infoActorRepository;

    public InfoActorServiceImpl(InfoActorRepository infoActorRepository) {
        this.infoActorRepository = infoActorRepository;
    }

    @Override
    public Set<InfoActor> listAllActors() {
        Set<InfoActor> infoActorList = new HashSet<InfoActor>();
        infoActorRepository.findAll().iterator().forEachRemaining(infoActorList::add);
        return infoActorList;
    }
}
