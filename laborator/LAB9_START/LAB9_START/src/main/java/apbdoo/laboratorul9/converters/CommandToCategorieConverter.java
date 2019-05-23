package apbdoo.laboratorul9.converters;

import apbdoo.laboratorul9.commands.CategorieCommand;
import apbdoo.laboratorul9.domain.Categorie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CommandToCategorieConverter
        implements Converter<CategorieCommand, Categorie> {

    @Nullable
    @Override
    public Categorie convert(CategorieCommand categorieCommand) {
        if (categorieCommand == null)
            return null;

        final Categorie categorie = new Categorie();
        categorie.setDenumire(categorieCommand.getDenumire());
        categorie.setId(categorieCommand.getId());

        return categorie;
    }
}
