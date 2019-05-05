package apbdoo.laboratorul9.converters;

import apbdoo.laboratorul9.commands.CategorieCommand;
import apbdoo.laboratorul9.domain.Categorie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategorieToCommandConverter
        implements Converter<Categorie, CategorieCommand> {

    @Nullable
    @Override
    public CategorieCommand convert(Categorie categorie) {
        if (categorie == null)
            return null;

        final CategorieCommand categorieCommand = new CategorieCommand();
        categorieCommand.setDenumire(categorie.getDenumire());
        categorieCommand.setId(categorie.getId());

        return categorieCommand;
    }
}
