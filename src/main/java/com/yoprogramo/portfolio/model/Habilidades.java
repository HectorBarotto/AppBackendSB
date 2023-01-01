
package com.yoprogramo.portfolio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name="habilidades")
@Getter @Setter
@Entity
public class Habilidades implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nivel")
    private Integer nivel;    
    @Column(name = "datos_personales_id")
    private Integer idDatosPersonalesFK;

    public Habilidades() {
    }

    public Habilidades(int id, String descripcion, int nivel, int idDatosPersonalesFK) {
        this.id = id;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    public Habilidades(String descripcion, int nivel, int idDatosPersonalesFK) {
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
}
