package apbdoo.laboratorul4.domain;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }




    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }



}
