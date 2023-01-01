
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
@Table(name="experiencia_laboral")
@Getter @Setter
@Entity
public class ExperienciaLaboral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "es_trabajo_actual")
    private Boolean isTrabajoActual;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "datos_personales_id")
    private Integer idDatosPersonalesFK;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(int id, String nombreEmpresa, String puesto, boolean isTrabajoActual, 
            LocalDate fechaInicio, LocalDate fechaFin, String descripcion, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.isTrabajoActual = isTrabajoActual;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }

        public ExperienciaLaboral(int id, String nombreEmpresa, String puesto, boolean isTrabajoActual, 
            String fechaInicio, String fechaFin, String descripcion, String urlLogo, int idDatosPersonalesFK) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.isTrabajoActual = isTrabajoActual;
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
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }
       
    public ExperienciaLaboral(String nombreEmpresa, String puesto, boolean isTrabajoActual, 
            LocalDate fechaInicio, LocalDate fechaFin, String descripcion, String urlLogo, int idDatosPersonalesFK) {
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.isTrabajoActual = isTrabajoActual;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }

        public ExperienciaLaboral(String nombreEmpresa, String puesto, boolean isTrabajoActual, 
            String fechaInicio, String fechaFin, String descripcion, String urlLogo, int idDatosPersonalesFK) {
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.isTrabajoActual = isTrabajoActual;
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
        this.descripcion = descripcion;
        this.urlLogo = urlLogo;
        this.idDatosPersonalesFK = idDatosPersonalesFK;
    }

}
