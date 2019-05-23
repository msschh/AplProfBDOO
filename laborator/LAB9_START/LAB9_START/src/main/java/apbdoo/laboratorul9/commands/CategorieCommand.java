package apbdoo.laboratorul9.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class CategorieCommand {
    private Long id;

    @NotNull(message = "required field")
    @Size(min=1, message ="required")
    private String denumire;
}
