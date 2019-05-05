package apbdoo.laboratorul9.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class InfoActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private String info;

}
