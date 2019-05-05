package apbdoo.laboratorul6.converters;

import apbdoo.laboratorul6.commands.CategorieCommand;
import apbdoo.laboratorul6.domain.Categorie;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

@Slf4j
public class CategorieToCommandConverterTest {

    public static final String denumire = "denumire categorie";
    public static final Long id = 1L;
    CategorieToCommandConverter categorieToCommandConverter;

    @Before
    public void initTest(){
        log.info("before test");
        categorieToCommandConverter = new CategorieToCommandConverter();
    }

    @Test
    public void convertNull(){
        log.info("test convert categorie to categorieCommand null");
        CategorieCommand categorieCommand = categorieToCommandConverter.convert(null);
        assertNull(categorieCommand);
    }

    @Test
    public void convert() {
        log.info("test convert categorie to categorieCommand");
        Categorie categorie = new Categorie();
        categorie.setDenumire(denumire);
        categorie.setId(id);
        CategorieCommand categorieCommand = categorieToCommandConverter.convert(categorie);

        assertNotNull(categorieCommand);
        assertEquals(categorie.getDenumire(), categorieCommand.getDenumire());
        assertEquals(categorie.getId(), categorieCommand.getId());
    }
}
