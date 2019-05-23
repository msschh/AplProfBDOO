package apbdoo.laboratorul6.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Film film;

    @Lob
    private String info;
   
}
