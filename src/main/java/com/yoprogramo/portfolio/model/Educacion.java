
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
@Table(name="educacion")
@Getter @Setter
@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "datos_personales_id")
    private int idDatosPersonalesFK;

    public Educacion() {
    }

    public Educacion(int id, String institucion, String titulo, String descripcion, LocalDate fechaInicio, 
            LocalDate fechaFin, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    public Educacion(int id, String institucion, String titulo, String descripcion, String fechaInicio, 
            String fechaFin, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
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
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    public Educacion(String institucion, String titulo, String descripcion, LocalDate fechaInicio, 
            LocalDate fechaFin, String urlLogo, int idDatosPersonalesFK) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
    public Educacion(String institucion, String titulo, String descripcion, String fechaInicio, 
            String fechaFin, String urlLogo, int idDatosPersonalesFK) {
        this.institucion = institucion;
        this.titulo = titulo;
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
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
}
