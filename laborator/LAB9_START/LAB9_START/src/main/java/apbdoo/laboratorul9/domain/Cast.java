package apbdoo.laboratorul9.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String actor;
    private String rol;
    @OneToOne
    private InfoActor infoActor;
    @ManyToOne
    private Film film;
    private BigDecimal nrEpisoade;





}
