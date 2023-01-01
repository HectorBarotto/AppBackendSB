
package com.yoprogramo.portfolio.model;

import com.yoprogramo.portfolio.controller.ControlFecha;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name="proyecto")
@Getter @Setter
@Entity
public class Proyecto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "proyecto")
    private String proyecto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "url")
    private String url;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "datos_personales_id")
    private Integer idDatosPersonalesFK;

    public Proyecto() {
    }

    public Proyecto(int id, String proyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, 
            String url, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.url = url;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    
    public Proyecto(int id, String proyecto, String descripcion, String fechaInicio, String fechaFin, 
            String url, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        try {
            this.fechaInicio = new ControlFecha().validaFecha(fechaInicio);
        } catch (Exception e) {
            this.fechaInicio = LocalDate.of(1900, 1, 1);
        }
        try {
            this.fechaFin = new ControlFecha().validaFecha(fechaFin);
        } catch (Exception e) {
            this.fechaFin = LocalDate.of(1900, 1, 1);
        }
        this.url = url;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    public Proyecto(String proyecto, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, 
            String url, String urlLogo, int idDatosPersonalesFK) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.url = url;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
}
