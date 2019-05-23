package apbdoo.laboratorul9.service;

import apbdoo.laboratorul9.commands.CategorieCommand;
import apbdoo.laboratorul9.converters.CategorieToCommandConverter;
import apbdoo.laboratorul9.converters.CommandToCategorieConverter;
import apbdoo.laboratorul9.domain.Categorie;
import apbdoo.laboratorul9.repositories.CategorieRepository;
import apbdoo.laboratorul9.services.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieServiceTest {
    public static final String DENUMIRE = "denumire";

    @Autowired
    CategorieService categorieService;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    CategorieToCommandConverter categorieToCommandConverter;

    @Autowired
    CommandToCategorieConverter commandToCategorieConverter;

    @Test
    public void testSaveCategorie(){
        Categorie categorie = categorieRepository.findByDenumire("comedie");
        CategorieCommand categorieCommand = categorieToCommandConverter.convert(categorie);
        categorieCommand.setDenumire(DENUMIRE);

        CategorieCommand savedCategoreCommand;
        savedCategoreCommand = categorieService.saveCategorieCommand(categorieCommand);

        assertEquals(DENUMIRE, savedCategoreCommand.getDenumire());
    }
}
