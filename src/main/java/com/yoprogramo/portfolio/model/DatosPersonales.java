
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


/**
 * Model (o Entity): La capa “model” trabaja estrechamente en conjunto con la clase Repository. 
 * Cada una de las clases modela un objeto de la vida real y es marcado con la annotation @Entity 
 * en caso de que se transforme en una entidad (tabla) en la base de datos. 
 * Cada instancia que se haga a una clase entity, en caso que sea persistida, 
 * representará una fila en una tabla de la base de datos.
 */

@Data
@Table(name="datos_personales")
@Getter @Setter
@Entity
public class DatosPersonales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_nac")
    private LocalDate fechaNac;
    @Column(name = "sobre_mi")
    private String sobreMi;
    @Column(name = "url_foto")
    private String urlFoto;
    @Column(name = "url_banner")
    private String urlBanner;
    @Column(name = "id_usuarioFK")
    private Integer idUsuarioFK;

    public DatosPersonales(){
    }
    public DatosPersonales(String nombre, String apellido, String domicilio, String telefono,
            String email, LocalDate fechaNac, String sobreMi, String urlFoto, String urlBanner ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
    }
    public DatosPersonales(String nombre, String apellido, String domicilio, String telefono,
            String email, LocalDate fechaNac, String sobreMi, String urlFoto, String urlBanner, Integer idUsuarioFK ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
        this.idUsuarioFK = idUsuarioFK;
    }
    public DatosPersonales(String nombre, String apellido, String domicilio, String telefono,
            String email, String fechaNac, String sobreMi, String urlFoto, String urlBanner, Integer idUsuarioFK ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        try {
            this.fechaNac = new ControlFecha().validaFecha(fechaNac);
        } catch (Exception e) {
            this.fechaNac = LocalDate.of(1900, 1, 1);
        }
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
        this.idUsuarioFK = idUsuarioFK;
    }

    public DatosPersonales(int id, String nombre, String apellido, String domicilio, String telefono,
            String email, String fechaNac, String sobreMi, String urlFoto, String urlBanner, Integer idUsuarioFK ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        try {
            this.fechaNac = new ControlFecha().validaFecha(fechaNac);
        } catch (Exception e) {
            this.fechaNac = LocalDate.of(1900, 1, 1);
        }
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
        this.idUsuarioFK = idUsuarioFK;
    }
    public DatosPersonales(int id, String nombre, String apellido, String domicilio, String telefono,
            String email, LocalDate fechaNac, String sobreMi, String urlFoto, String urlBanner, Integer idUsuarioFK ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.sobreMi = sobreMi;
        this.urlFoto = urlFoto;
        this.urlBanner = urlBanner;
        this.idUsuarioFK = idUsuarioFK;
    }
}
