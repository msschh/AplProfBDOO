package apbdoo.laboratorul6.services;

import apbdoo.laboratorul6.domain.InfoActor;
import apbdoo.laboratorul6.repositories.InfoActorRepository;
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
