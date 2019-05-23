package apbdoo.laboratorul6.services;

import apbdoo.laboratorul6.commands.CategorieCommand;
import apbdoo.laboratorul6.converters.CategorieToCommandConverter;
import apbdoo.laboratorul6.converters.CommandToCategorieConverter;
import apbdoo.laboratorul6.domain.Categorie;
import apbdoo.laboratorul6.repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class CategorieServiceImpl implements CategorieService {
    CategorieRepository categorieRepository;
    CommandToCategorieConverter commandToCategorieConverter;
    CategorieToCommandConverter categorieToCommandConverter;

    @Override
    public CategorieCommand saveCategorieCommand(CategorieCommand categorieCommand) {
        Categorie categorie = commandToCategorieConverter.convert(categorieCommand);
        log.info("saving categorie " + categorie.getDenumire());
        Categorie savedCategorie = categorieRepository.save(categorie);
        return categorieToCommandConverter.convert(savedCategorie);
    }
}
