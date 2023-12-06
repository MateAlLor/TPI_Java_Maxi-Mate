package org.example.dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EstimadoPorProblema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    TipoProblema tipoProblema;
    Integer horasEstimadas;
    public EstimadoPorProblema() {
    }
    ;

    public EstimadoPorProblema(TipoProblema tipoProblema, Integer horasEstimadas) {
        this.tipoProblema = tipoProblema;
        this.horasEstimadas = horasEstimadas;
    }
}
