package apbdoo.laboratorul9.repositories;


import apbdoo.laboratorul9.domain.Categorie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieRepositoryTest {
    public static final String DENUMIRE = "denumire";

    @Autowired
    CategorieRepository categorieRepository;

    @Test
    public void testLazyLoading(){
       
    }

}
